package com.vullpes.diaryapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.vullpes.diaryapp.data.database.ImageToDeleteDao
import com.vullpes.diaryapp.data.database.ImagesToUploadDao
import com.vullpes.diaryapp.navigation.Screen
import com.vullpes.diaryapp.navigation.SetupNavGraph
import com.vullpes.diaryapp.ui.theme.DiaryAppTheme
import com.vullpes.diaryapp.util.Constants.APP_ID
import com.vullpes.diaryapp.util.UtilFunctions.retryDeleteImagesFromFirebase
import com.vullpes.diaryapp.util.UtilFunctions.retryUploadingImageToFirebase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
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
}

