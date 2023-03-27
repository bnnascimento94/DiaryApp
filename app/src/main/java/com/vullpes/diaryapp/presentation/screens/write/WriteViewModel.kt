package com.vullpes.diaryapp.presentation.screens.write

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.vullpes.diaryapp.data.database.ImageToDeleteDao
import com.vullpes.diaryapp.data.database.ImagesToUploadDao
import com.vullpes.diaryapp.data.database.entity.ImageToDelete
import com.vullpes.diaryapp.data.database.entity.ImageToUpload
import com.vullpes.diaryapp.data.repository.MongoDb
import com.vullpes.diaryapp.model.*
import com.vullpes.diaryapp.util.Constants.WRITE_SCREEN_ARGUMENT_KEY
import com.vullpes.diaryapp.util.RequestState
import com.vullpes.diaryapp.util.UtilFunctions.fetchImagesFromFirebase
import com.vullpes.diaryapp.util.UtilFunctions.toRealmInstant
import dagger.hilt.android.lifecycle.HiltViewModel
import io.realm.kotlin.types.ObjectId
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.ZonedDateTime
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val imagesToUploadDao: ImagesToUploadDao,
    private val imageToDeleteDao: ImageToDeleteDao
): ViewModel() {
    val galleryState = GalleryState()
    var uiState by mutableStateOf(UiState())
    private set

    init {
        getDairyArgument()
        fetchSelectedDiary()
    }

    private fun getDairyArgument(){
        uiState = uiState.copy(
            selectedDiaryId = savedStateHandle.get<String>(
                key = WRITE_SCREEN_ARGUMENT_KEY
            )
        )
    }

    private fun fetchSelectedDiary(){
        if(uiState.selectedDiaryId != null){
            viewModelScope.launch(Dispatchers.Main) {
                 MongoDb.getSelectedDiary(
                    diaryId = ObjectId.Companion.from(uiState.selectedDiaryId!!)
                )
                     .catch { emit(RequestState.Error(Exception("Diary is already deleted"))) }
                     .collect{ diary ->
                     if(diary is RequestState.Success){
                         setSelectedDiary(diary = diary.data)
                         setTitle(title = diary.data.title)
                         setDescription(description = diary.data.description)
                         setMood(mood = Mood.valueOf(diary.data.mood))

                         fetchImagesFromFirebase(
                             remoteImagesPaths = diary.data.images,
                             onImageDownload = {downloadedImage ->
                                 galleryState.addImage(
                                     GalleryImage(
                                         image = downloadedImage,
                                         remoteImagePath = extractRemoteImagePath(
                                             fullImageUrl = downloadedImage.toString()
                                         )
                                     )
                                 )
                             }
                         )

                     }
                 }


            }
        }
    }

    private fun extractRemoteImagePath(fullImageUrl: String): String {
        val chunks = fullImageUrl.split("%2F")
        val imageName = chunks[2].split("?").first()
        return "images/${Firebase.auth.currentUser?.uid}/$imageName"
    }

    fun setTitle(title: String){
        uiState = uiState.copy(title = title)
    }

    fun setDescription(description: String){
        uiState = uiState.copy(description = description)
    }

   private fun setMood(mood: Mood){
        uiState = uiState.copy(mood = mood)
   }

    private fun setSelectedDiary(diary: Diary){
        uiState = uiState.copy(selectedDiary = diary)
    }

    fun updateDateTime(zonedDateTime: ZonedDateTime){
         uiState = uiState.copy(updatedDateTime = zonedDateTime.toInstant().toRealmInstant())
    }

    fun upsertDiary(
        diary: Diary,
        onSuccess:() -> Unit,
        onError:(String) ->Unit
    ) = viewModelScope.launch(Dispatchers.IO){
            if(uiState.selectedDiaryId != null){
                updateDiary(diary = diary, onSuccess = onSuccess, onError = onError)
            }else{
                insertDiary(diary = diary, onSuccess = onSuccess, onError = onError)
            }

    }

   private suspend fun insertDiary(
        diary: Diary,
        onSuccess:() -> Unit,
        onError:(String) ->Unit
    ){
        val result = MongoDb.insertDiary(diary = diary.apply {
            if(uiState.updatedDateTime != null){
                this.date = uiState.updatedDateTime!!
            }
        })
        if(result is RequestState.Success){
            upLoadImagesToFirebase()
            withContext(Dispatchers.Main){
                onSuccess()
            }
        }else if (result is RequestState.Error){
            withContext(Dispatchers.Main){
                onError(result.error.message.toString())
            }
        }
    }

   private suspend fun updateDiary(
        diary: Diary,
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    ){
        val result = MongoDb.updateDiary(diary = diary.apply {
            _id = ObjectId.Companion.from(uiState.selectedDiaryId!!)
            date = if(uiState.updatedDateTime != null){
                uiState.updatedDateTime!!
            }else{
                uiState.selectedDiary!!.date
            }
        })
        if(result is RequestState.Success){
            upLoadImagesToFirebase()
            deleteImagesFromFirebase()
            withContext(Dispatchers.Main){
                onSuccess()
            }
        }else if(result is RequestState.Error){
            withContext(Dispatchers.Main){
                onError(result.error.message.toString())
            }


        }

    }

    fun deleteDiary(
        onSuccess: () -> Unit,
        onError: (String) -> Unit
    )= viewModelScope.launch(Dispatchers.IO){
        if(uiState.selectedDiaryId != null){
            val result = MongoDb.deleteDiary(id = ObjectId.from(uiState.selectedDiaryId!!))
            if(result is RequestState.Success){
                withContext(Dispatchers.Main){
                    uiState.selectedDiary?.let { deleteImagesFromFirebase(images = it.images) }
                    onSuccess()
                }
            }else if(result is RequestState.Error){
                withContext(Dispatchers.Main){
                    onError(result.error.message.toString())
                }
            }

        }
    }

    fun addImage(image: Uri, imageType:String){
        val remoteImagePath = "images/${FirebaseAuth.getInstance().currentUser?.uid}"+
                "${image.lastPathSegment}-${System.currentTimeMillis()}.$imageType"
        galleryState.addImage(
            GalleryImage(
                image = image,
                remoteImagePath = remoteImagePath
            )
        )
    }

    private fun upLoadImagesToFirebase(){
        val storage = FirebaseStorage.getInstance().reference
        galleryState.images.forEach { galleryImage ->
            val imagePath = storage.child(galleryImage.remoteImagePath)
            imagePath.putFile(galleryImage.image)
                .addOnProgressListener {
                    val session = it.uploadSessionUri
                    if(session != null){
                        viewModelScope.launch(Dispatchers.IO) {
                            imagesToUploadDao.addImageToUpload(
                                ImageToUpload(
                                    remoteImagePath = galleryImage.remoteImagePath,
                                    imageUri = galleryImage.image.toString(),
                                    sessionUri = session.toString()
                                )
                            )
                        }

                    }
                }
        }
    }

    private fun deleteImagesFromFirebase(images: List<String>? = null){
        val storage = FirebaseStorage.getInstance().reference
        if(images != null){
            images.forEach{remotePath ->
                storage.child(remotePath).delete()
                    .addOnFailureListener{
                        viewModelScope.launch(Dispatchers.IO) {
                            imageToDeleteDao.addImageToDelete(
                                ImageToDelete(remoteImagePath = remotePath)
                            )
                        }
                    }
            }
        }else{
             galleryState.imagesToBeDeleted.map{it.remoteImagePath}.forEach {remoteImagePath ->
                storage.child(remoteImagePath).delete()
                    .addOnFailureListener{
                        viewModelScope.launch(Dispatchers.IO) {
                            imageToDeleteDao.addImageToDelete(
                                ImageToDelete(remoteImagePath = remoteImagePath)
                            )
                        }
                    }
            }
        }
    }
}

