package com.exemple.jetgyfs.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.exemple.jetgyfs.presentation.gif.GifHomeScreen
import com.exemple.jetgyfs.ui.theme.JetGyfsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetGyfsTheme {
                MyApp {
                    GifHomeScreen()
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
