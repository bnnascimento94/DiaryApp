package com.vullpes.diaryapp.util

import android.net.Uri
import androidx.core.net.toUri
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storageMetadata
import com.vullpes.diaryapp.data.database.entity.ImageToDelete
import com.vullpes.diaryapp.data.database.entity.ImageToUpload
import io.realm.kotlin.types.RealmInstant
import java.time.Instant

object UtilFunctions {

    fun RealmInstant.toInstant(): Instant{
        val sec : Long = this.epochSeconds
        val nano : Int = this.nanosecondsOfSecond
        return if(sec >=0){
            Instant.ofEpochSecond(sec,nano.toLong())
        }else{
            Instant.ofEpochSecond(sec-1,1_000_000 + nano.toLong())
        }
    }
     fun Instant.toRealmInstant(): RealmInstant{
         val sec: Long = this.epochSecond
         val nano: Int = this.nano
         return if(sec >=0){
             RealmInstant.from(sec,nano)
         }else{
             RealmInstant.from(sec + 1, -1_000_000 + nano)
         }
     }

    fun fetchImagesFromFirebase(
        remoteImagesPaths: List<String>,
        onImageDownload: (Uri) ->Unit,
        onImageDownloadFailed: (Exception) ->Unit = {},
        onReadyToDisplay: () ->Unit = {}
    ){
        if(remoteImagesPaths.isNotEmpty()){
            remoteImagesPaths.forEachIndexed { index, image ->
                if(image.trim().isNotEmpty()){
                    FirebaseStorage.getInstance().reference.child(image.trim()).downloadUrl
                        .addOnSuccessListener{
                            onImageDownload(it)
                            if(remoteImagesPaths.lastIndexOf(remoteImagesPaths.last()) == index){
                                onReadyToDisplay()
                            }
                        }.addOnFailureListener{
                            onImageDownloadFailed(it)
                        }

                }
            }
        }
    }

    fun retryUploadingImageToFirebase(
        imageToUpload: ImageToUpload,
        onSuccess:() -> Unit
    ){
        val storage = FirebaseStorage.getInstance().reference
        storage.child(imageToUpload.remoteImagePath).putFile(
            imageToUpload.imageUri.toUri(),
            storageMetadata {  },
            imageToUpload.sessionUri.toUri()
        ).addOnSuccessListener { onSuccess() }

    }

    fun retryDeleteImagesFromFirebase(
        imageToDelete: ImageToDelete,
        onSuccess: () -> Unit
    ){
        val storage = FirebaseStorage.getInstance().reference
        storage.child(imageToDelete.remoteImagePath).delete()
            .addOnSuccessListener {
                onSuccess()
            }
    }

}