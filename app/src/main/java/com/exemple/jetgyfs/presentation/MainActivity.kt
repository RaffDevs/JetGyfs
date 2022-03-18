package com.exemple.jetgyfs.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.exemple.jetgyfs.presentation.gif.navigation.GiffNavigation
import com.exemple.jetgyfs.ui.theme.JetGyfsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetGyfsTheme {
                MyApp {
                    GiffNavigation()
                }
            }
        }
    }

    @Composable
    fun MyApp(content: @Composable () -> Unit) {
        JetGyfsTheme {
            content()

        }
    }
}
