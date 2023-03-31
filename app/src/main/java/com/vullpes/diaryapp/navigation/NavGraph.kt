package com.vullpes.diaryapp.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.vullpes.auth.navigation.authenticationRoute
import com.vullpes.home.navigation.homeRoute
import com.vullpes.util.Screen
import com.vullpes.write.navigation.writeRoute

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






