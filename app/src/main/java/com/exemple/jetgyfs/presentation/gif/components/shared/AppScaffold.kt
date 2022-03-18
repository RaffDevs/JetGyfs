package com.exemple.jetgyfs.presentation.gif.components.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun AppScaffold(
    scaffoldState: ScaffoldState,
    navController: NavController,
    content: @Composable () -> Unit
) {
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppToolbar(
                scaffoldState = scaffoldState,
                scope = scope
            )
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
            Column(
                modifier = Modifier
                    .padding(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()
            }
        }
    }
}