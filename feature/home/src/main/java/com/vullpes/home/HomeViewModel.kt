package com.vullpes.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.storage.FirebaseStorage
import com.vullpes.mongo.repository.Diaries
import com.vullpes.mongo.database.ImageToDeleteDao
import com.vullpes.mongo.database.entity.ImageToDelete
import com.vullpes.mongo.repository.MongoDb
import com.vullpes.util.conectivity.ConectivityObserver
import com.vullpes.util.conectivity.NetworkConectivityObserver
import com.vullpes.util.model.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.time.ZonedDateTime
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.N)
@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val connectivity: NetworkConectivityObserver,
    private val imageToDeleteDao: ImageToDeleteDao
): ViewModel() {
    private var network by mutableStateOf(ConectivityObserver.Status.Unavailable)
    var diaries : MutableState<Diaries> = mutableStateOf(RequestState.Idle)
    var dateIsSelected by mutableStateOf(false)
        private set
    private lateinit var allDiariesJob: Job
    private lateinit var filteredDiariesJob: Job

    init {
        getDiaries()
        viewModelScope.launch {
            connectivity.observe().collect{network = it}
        }
    }

    fun getDiaries(zonedDateTime: ZonedDateTime? = null){
       dateIsSelected = zonedDateTime != null
       diaries.value = RequestState.Loading
       if(dateIsSelected && zonedDateTime != null){
            observeFilteredDiaries(zonedDateTime = zonedDateTime)
       }else{
            observeAllDiaries()
       }
    }

    private fun observeAllDiaries() {
       allDiariesJob =  viewModelScope.launch {
           if(::filteredDiariesJob.isInitialized){
               filteredDiariesJob.cancelAndJoin()
           }
           MongoDb.getAllDiaries().collect { result ->
                diaries.value = result
            }
        }
    }

    private fun observeFilteredDiaries(zonedDateTime: ZonedDateTime){
       filteredDiariesJob =  viewModelScope.launch {
           if(::allDiariesJob.isInitialized){
               allDiariesJob.cancelAndJoin()
           }
           MongoDb.getFilteredDiaries(zonedDateTime).collect{ result ->
                diaries.value = result
            }
        }
    }

    fun deleteAllDiaries(
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ){
        if(network == ConectivityObserver.Status.Available){
            val userId = FirebaseAuth.getInstance().currentUser?.uid
            val imagesDirectory = "images/${userId}"
            val storage = FirebaseStorage.getInstance().reference
            storage.child(imagesDirectory)
                .listAll()
                .addOnSuccessListener {
                    it.items.forEach { ref ->
                        val imagePath = "images/${userId}/${ref.name}"
                        storage.child(imagePath).delete()
                            .addOnFailureListener{ error ->
                                viewModelScope.launch(Dispatchers.IO) {
                                    imageToDeleteDao.addImageToDelete(
                                        ImageToDelete(remoteImagePath = imagePath)
                                    )
                                }
                            }
                    }
                    viewModelScope.launch(Dispatchers.IO) {
                        val result = MongoDb.deleteAllDiaries()
                        if(result is RequestState.Success){
                            withContext(Dispatchers.Main){
                                onSuccess()
                            }
                        } else if(result is RequestState.Error){
                            withContext(Dispatchers.Main){
                                onError(Exception(result.error.message.toString()))
                            }
                        }
                    }
                }.addOnFailureListener {
                    onError(it)
                }
        } else{
            onError(Exception("No Internet Connection."))
        }
    }


}