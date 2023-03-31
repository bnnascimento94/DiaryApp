package com.vullpes.diaryapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storageMetadata
import com.vullpes.diaryapp.navigation.SetupNavGraph
import com.vullpes.mongo.database.ImageToDeleteDao
import com.vullpes.mongo.database.ImagesToUploadDao
import com.vullpes.mongo.database.entity.ImageToDelete
import com.vullpes.mongo.database.entity.ImageToUpload
import com.vullpes.ui.theme.DiaryAppTheme
import com.vullpes.util.Constants.APP_ID
import com.vullpes.util.Screen
import dagger.hilt.android.AndroidEntryPoint
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.N)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var imagesToUploadDao: ImagesToUploadDao

    @Inject
    lateinit var imageToDeleteDao: ImageToDeleteDao

    var keepSplashOpened = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().setKeepOnScreenCondition {
            keepSplashOpened
        }
        // deixar as barras de navegação do android transparentes
        WindowCompat.setDecorFitsSystemWindows(window, false)
        FirebaseApp.initializeApp(this)
        setContent {
            DiaryAppTheme {
                val navController = rememberNavController()
                SetupNavGraph(
                    firstDestination = getStartDestination(),
                    navController = navController
                ) {
                    keepSplashOpened = false
                }
            }
        }
        cleanupCheck(scope = lifecycleScope, imagesToUploadDao, imageToDeleteDao)
    }

    private fun getStartDestination(): String {
        val user = App.Companion.create(APP_ID).currentUser
        return if (user != null && user.loggedIn) Screen.Home.route
        else Screen.Authentication.route
    }

    private fun cleanupCheck(
        scope: CoroutineScope,
        imagesToUploadDao: ImagesToUploadDao,
        imageToDeleteDao: ImageToDeleteDao
    ) {
        scope.launch(Dispatchers.IO) {
            val result = imagesToUploadDao.getAllImages()
            result.forEach { imageToUpload ->
                retryUploadingImageToFirebase(
                    imageToUpload,
                    onSuccess = {
                        scope.launch(Dispatchers.IO) {
                            imagesToUploadDao.cleanupImage(imageId = imageToUpload.id)
                        }
                    }
                )
            }
            val result2 = imageToDeleteDao.getAllImages()
            result2.forEach {
                retryDeleteImagesFromFirebase(it, onSuccess = {
                    scope.launch(Dispatchers.IO) {
                        imageToDeleteDao.cleanupImageToDelete(imageId = it.id)
                    }
                })
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

