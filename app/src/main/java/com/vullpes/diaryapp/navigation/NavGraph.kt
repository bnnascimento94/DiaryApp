package com.vullpes.diaryapp.navigation

import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.stevdzasan.messagebar.rememberMessageBarState
import com.stevdzasan.onetap.rememberOneTapSignInState
import com.vullpes.diaryapp.model.GalleryImage
import com.vullpes.diaryapp.model.Mood
import com.vullpes.diaryapp.model.rememberGalleryState
import com.vullpes.diaryapp.presentation.components.CustomAlertDialog
import com.vullpes.diaryapp.presentation.screens.auth.AuthenticationScreen
import com.vullpes.diaryapp.presentation.screens.auth.AuthenticationViewModel
import com.vullpes.diaryapp.presentation.screens.home.HomeScreen
import com.vullpes.diaryapp.presentation.screens.home.HomeViewModel
import com.vullpes.diaryapp.presentation.screens.write.WriteScreen
import com.vullpes.diaryapp.presentation.screens.write.WriteViewModel
import com.vullpes.diaryapp.util.Constants.APP_ID
import com.vullpes.diaryapp.util.Constants.WRITE_SCREEN_ARGUMENT_KEY
import com.vullpes.diaryapp.util.RequestState
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun SetupNavGraph(
    firstDestination: String,
    navController: NavHostController,
    onDataLoaded: () -> Unit
) {

    NavHost(
        startDestination = firstDestination, navController = navController
    ) {
        authenticationRoute(onDataLoaded = onDataLoaded,
            navigateToHome = {
                navController.popBackStack()
                navController.navigate(Screen.Home.route)
            })
        homeRoute(
            navigateToWrite = { navController.navigate(Screen.Write.route) },
            navigateToAuth = {
                navController.popBackStack()
                navController.navigate(Screen.Write.route)
            },
            onDataLoaded = onDataLoaded,
            navigateToWriteWithArgs = {
                navController.navigate(Screen.Write.passDiaryId(diaryId = it))
            }
        )
        writeRoute(onBackPressed = {
            navController.popBackStack()
        })
    }
}

fun NavGraphBuilder.authenticationRoute(
    navigateToHome: () -> Unit,
    onDataLoaded: () -> Unit
) {
    composable(route = Screen.Authentication.route) {
        val viewModel: AuthenticationViewModel = hiltViewModel()
        val authenticated = viewModel.authenticated
        val loadingState = viewModel.loadingState
        val oneTapState = rememberOneTapSignInState()
        val messageBarState = rememberMessageBarState()

        LaunchedEffect(key1 = Unit) {
            onDataLoaded()
        }

        AuthenticationScreen(
            authenticated = authenticated,
            loadingState = loadingState,
            onButtonClicked = {
                oneTapState.open()
                viewModel.setLoading(true)
            },
            onetapState = oneTapState,
            messageBarState = messageBarState,
            onSuccessfulFirebaseSignIn = { tokenId ->
                viewModel.signInWithMongoAtlas(tokenId,
                    onSuccess = {
                        messageBarState.addSuccess("Successfully Authenticated!")
                        viewModel.setLoading(false)
                    },
                    onError = {
                        messageBarState.addError(it)
                        viewModel.setLoading(false)
                    })

            },
            onDialogDismissed = { message ->
                //messageBarState.addError(Exception(message = message))
                viewModel.setLoading(false)
            },
            navigateToHome = navigateToHome,
            onFailedFirebaseSignIn = {
                messageBarState.addError(it)
                viewModel.setLoading(false)
            }
        )
    }
}


@RequiresApi(Build.VERSION_CODES.N)
fun NavGraphBuilder.homeRoute(
    navigateToWrite: () -> Unit,
    navigateToWriteWithArgs: (String) -> Unit,
    navigateToAuth: () -> Unit,
    onDataLoaded: () -> Unit
) {



    composable(route = Screen.Home.route) {
        val viewModel: HomeViewModel = hiltViewModel()
        val diaries by viewModel.diaries
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        var signOutDialogOpened by remember {
            mutableStateOf(false)
        }
        var deleteAllDialogOpened by remember {
            mutableStateOf(false)
        }
        val scope = rememberCoroutineScope()
        val context = LocalContext.current

        LaunchedEffect(key1 = diaries) {
            if (diaries !is RequestState.Loading) {
                onDataLoaded()
            }
        }

        HomeScreen(
            diaries = diaries,
            drawerState = drawerState,
            onMenuClicked = {
                scope.launch {
                    drawerState.open()
                }
            },
            onSignOutClicked = { signOutDialogOpened = true },
            navigateToWrite = navigateToWrite,
            navigateToWriteWithArgs = navigateToWriteWithArgs,
            onDeleteAllClicked = {
                deleteAllDialogOpened = true
            },
            dateIsSelected = viewModel.dateIsSelected,
            onDateSelected = {
                viewModel.getDiaries(zonedDateTime = it)
            },
            onDateReset = {
                viewModel.getDiaries()
            }
        )

        CustomAlertDialog(
            title = "Sign out",
            message = "Are you sure you want to sign out from your google account?",
            dialogOpened = signOutDialogOpened,
            onCloseDialog = { signOutDialogOpened = false }
        ) {
            scope.launch(Dispatchers.IO) {
                val user = App.create(APP_ID).currentUser
                user?.logOut()?.let {
                    withContext(Dispatchers.Main) {
                        navigateToAuth()
                    }
                }
            }
        }

        CustomAlertDialog(
            title = "Delete All Diaries",
            message = "Are you sure you want to permanently delete all diaries?",
            dialogOpened = deleteAllDialogOpened,
            onCloseDialog = { deleteAllDialogOpened = false },
            onYesClicked = {
                viewModel.deleteAllDiaries(
                    onSuccess = {
                        Toast.makeText(context,"All diaries deleted", Toast.LENGTH_LONG).show()
                        scope.launch{
                            drawerState.close()
                        }
                    },
                    onError = {
                        Toast.makeText(context,
                            if(it.message == "No Internet Connection") "We need an Internet connection for this operation"
                            else it.message,
                            Toast.LENGTH_LONG).show()
                        scope.launch{
                            drawerState.close()
                        }
                    }
                )
            }
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
fun NavGraphBuilder.writeRoute(onBackPressed: () -> Unit) {

    composable(
        route = Screen.Write.route,
        arguments = listOf(navArgument(name = WRITE_SCREEN_ARGUMENT_KEY) {
            type = NavType.StringType
            nullable = true
            defaultValue = null
        })
    ) {
        val viewModel: WriteViewModel = hiltViewModel()
        val galleryState = viewModel.galleryState
        val uiState = viewModel.uiState
        val pagerState = rememberPagerState()
        val pageNumber by remember {
            derivedStateOf { pagerState.currentPage }
        }
        val context = LocalContext.current

        LaunchedEffect(key1 = uiState) {
            Log.d("SelectedDiary", "${uiState.selectedDiaryId}) ")
        }

        WriteScreen(
            onDeleteConfirmed = {
                viewModel.deleteDiary(
                    onSuccess = {
                       Toast.makeText(context,"Deleted",Toast.LENGTH_SHORT).show()
                        onBackPressed()
                    },
                    onError = {
                        Toast.makeText(context,"Error to delete",Toast.LENGTH_SHORT).show()
                        onBackPressed()
                    })
            },
            onBackPressed = onBackPressed,
            pagerState = pagerState,
            uiState = viewModel.uiState,
            ontitleChanged = { viewModel.setTitle(title = it) },
            onDescriptionChanged = { viewModel.setDescription(description = it) },
            moodName = { Mood.values()[pageNumber].name },
            onSaveClicked = { diary ->
                viewModel.upsertDiary(
                    diary = diary.apply { mood = Mood.values()[pageNumber].name },
                    onSuccess = {onBackPressed()},
                    onError = {Toast.makeText(context,it,Toast.LENGTH_SHORT).show()}
                )
            },
            onDateTimeUpdated = {viewModel.updateDateTime(it)},
            galleryState = galleryState,
            onImageSelect = {
                val type = context.contentResolver.getType(it)?.split("/")?.last() ?: "jpg"
                viewModel.addImage(
                    image = it,
                    imageType = type
                )
            },
            onImageDeleteClicked = {galleryState.removeImage(it)}
        )
    }
}