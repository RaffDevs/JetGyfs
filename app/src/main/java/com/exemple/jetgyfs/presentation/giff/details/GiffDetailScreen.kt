package com.exemple.jetgyfs.presentation.giff.details

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.exemple.jetgyfs.data.datasource.api.entity.DataEntity
import com.exemple.jetgyfs.presentation.shared.AppScaffold
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GiffDetailScreen(
    detailViewModel: GiffDetailViewModel = hiltViewModel(),
    navController: NavController,
    giff: DataEntity
) {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    val context = LocalContext.current

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
                    val currentGiff = detailViewModel.getFavoriteGiffByTitle(giff.title)

                    if (currentGiff != null) {
                        detailViewModel.likeGiff(
                            detailViewModel.toFavoriteGiff(giff),
                            onSuccess = { success ->
                                Toast.makeText(
                                    context,
                                    success,
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            onError = { error ->
                                Toast.makeText(
                                    context,
                                    error,
                                    Toast.LENGTH_SHORT
                                ).show()

                                navController.popBackStack()
                            }
                        )
                    } else {
                        detailViewModel.unlikeGiff(
                            currentGiff?.id.toString(),
                            onSuccess = { success ->
                                Toast.makeText(
                                    context,
                                    success,
                                    Toast.LENGTH_SHORT
                                ).show()

                                navController.popBackStack()
                            },
                            onError = { error ->
                                Toast.makeText(
                                    context,
                                    error,
                                    Toast.LENGTH_SHORT
                                ).show()

                                navController.popBackStack()
                            }
                        )
                    }

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