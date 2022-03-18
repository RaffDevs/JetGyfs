package com.exemple.jetgyfs.presentation.gif.components.shared

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.exemple.jetgyfs.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppToolbar(
    scaffoldState: ScaffoldState,
    scope: CoroutineScope
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    scope.launch {
                        scaffoldState.drawerState.open()
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Icon" )
            }
        }
    )
}