package com.exemple.jetgyfs.presentation.gif

import androidx.compose.material.DrawerValue
import androidx.compose.material.Text
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.exemple.jetgyfs.domain.model.Data
import com.exemple.jetgyfs.presentation.gif.components.shared.AppScaffold

@Composable
fun GiffDetailScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController
    ) {
        Text(text = "Hello")
    }
}