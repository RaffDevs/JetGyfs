package com.exemple.jetgyfs.presentation.gif

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.exemple.jetgyfs.domain.model.Data
import com.exemple.jetgyfs.presentation.gif.components.shared.AppScaffold
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GiffDetailScreen(
    navController: NavController,
    giff: Data
) {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
        enableBackNavigation = true
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                giff.title,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 28.sp
                ),
                modifier = Modifier
                    .padding(12.dp)
                    .align(alignment = Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(30.dp))
            GlideImage(
                modifier = Modifier
                    .size(320.dp)
                    .padding(4.dp),
                imageModel = giff.images.fixed_height.url,
                contentDescription = giff.title,
                loading = {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            )
            Row() {
                IconButton(onClick = {
                    Log.d("Teste", "Hello")
                }) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = "Heart icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(28.dp)
                    )
                }
                IconButton(onClick = {
                    Log.d("Teste", "Hello")
                }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Share Icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(28.dp)
                    )
                }
            }
        }
    }
}