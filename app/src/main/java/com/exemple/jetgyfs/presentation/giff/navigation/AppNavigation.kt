package com.exemple.jetgyfs.presentation.giff.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.exemple.jetgyfs.data.datasource.api.entity.DataEntity
import com.exemple.jetgyfs.presentation.giff.details.GiffDetailScreen
import com.exemple.jetgyfs.presentation.giff.home.GiffHomeScreen
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
            val giffObject = Gson().fromJson<DataEntity>(giffJson, DataEntity::class.java)
            GiffDetailScreen(
                navController = navController,
                giff = giffObject
            )
        }
    }
}