package com.exemple.jetgyfs.presentation.shared

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun AppScaffold(
    scaffoldState: ScaffoldState,
    navController: NavController,
    enableBackNavigation: Boolean = false,
    content: @Composable () -> Unit,
) {
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(
                scaffoldState = scaffoldState,
                scope = scope,
                isBackNavigationButtonEnabled = enableBackNavigation
            ) {
                navController.popBackStack()
            }
        },
        drawerContent = {
            AppDrawer(navController = navController)
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = Color.Black
        ) {
            content()
        }
    }
}