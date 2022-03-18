package com.exemple.jetgyfs.presentation.gif.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exemple.jetgyfs.domain.model.Data
import com.exemple.jetgyfs.presentation.gif.GiffDetailScreen
import com.exemple.jetgyfs.presentation.gif.GiffHomeScreen
import com.google.gson.Gson

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

        composable(
            AppScreens.DETAIL.name + "?giff={giff}",
            arguments = listOf(
                navArgument(name = "giff") {
                    type = NavType.StringType
                }
            )

        ) { backStackEntry ->
            val giffJson = backStackEntry.arguments?.getString("giff")
            val giffObject = Gson().fromJson<Data>(giffJson, Data::class.java)
            GiffDetailScreen(
                navController = navController,
                giffObject
            )
        }
    }
}