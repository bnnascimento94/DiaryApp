package com.vullpes.home.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.vullpes.ui.components.CustomAlertDialog
import com.vullpes.util.Constants.APP_ID
import com.vullpes.util.Screen
import com.vullpes.util.model.RequestState
import io.realm.kotlin.mongodb.App
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@RequiresApi(Build.VERSION_CODES.N)
fun NavGraphBuilder.homeRoute(
    navigateToWrite: () -> Unit,
    navigateToWriteWithArgs: (String) -> Unit,
    navigateToAuth: () -> Unit,
    onDataLoaded: () -> Unit
) {



    composable(route = Screen.Home.route) {
        val viewModel: com.vullpes.home.HomeViewModel = hiltViewModel()
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

        com.vullpes.home.HomeScreen(
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
            scope.launch(kotlinx.coroutines.Dispatchers.IO) {
                val user = App.create(APP_ID).currentUser
                user?.logOut()?.let {
                    withContext(kotlinx.coroutines.Dispatchers.Main) {
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
                        android.widget.Toast.makeText(context,"All diaries deleted", android.widget.Toast.LENGTH_LONG).show()
                        scope.launch{
                            drawerState.close()
                        }
                    },
                    onError = {
                        android.widget.Toast.makeText(context,
                            if(it.message == "No Internet Connection") "We need an Internet connection for this operation"
                            else it.message,
                            android.widget.Toast.LENGTH_LONG).show()
                        scope.launch{
                            drawerState.close()
                        }
                    }
                )
            }
        )
    }
}