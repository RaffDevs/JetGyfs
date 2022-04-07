package com.exemple.jetgyfs.presentation.shared

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.exemple.jetgyfs.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppToolbar(
    scaffoldState: ScaffoldState,
    scope: CoroutineScope,
    isBackNavigationButtonEnabled: Boolean,
    backNavigationButtonAction: () -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        navigationIcon = {
            if (isBackNavigationButtonEnabled) {
                IconButton(
                    onClick = {
                        backNavigationButtonAction.invoke()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow back Icon"
                    )
                }
            } else {
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

        }
    )
}