package com.exemple.jetgyfs.presentation.gif.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.exemple.jetgyfs.presentation.gif.GiffDetailScreen
import com.exemple.jetgyfs.presentation.gif.GiffHomeScreen

@Composable
fun GiffNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HOME.name
    ) {

        composable(AppScreens.HOME.name) {
            GiffHomeScreen(navController = navController)
        }

        composable(AppScreens.DETAIL.name) {
            GiffDetailScreen(navController = navController)
        }
    }
}