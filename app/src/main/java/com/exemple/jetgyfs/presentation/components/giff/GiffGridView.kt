package com.exemple.jetgyfs.presentation.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.exemple.jetgyfs.data.datasource.api.entity.DataEntity
import com.exemple.jetgyfs.presentation.giff.navigation.AppScreens
import com.google.gson.Gson

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GiffGridView(
    navController: NavController,
    giffs: List<DataEntity>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(8.dp)
        ){
            items(giffs.size) { index ->
                val item = giffs[index]

                if ((index + 1) == giffs.size) {
                    LoadMoreGiffsButton()
                } else {
                    GiffGridCell(giff = item) { giff ->
                        val giffJson = Gson().toJson(giff)

                        navController.navigate(
                            route = AppScreens.DETAIL.name + "?giff={giff}"
                                .replace("{giff}", giffJson )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LoadMoreGiffsButton() {
    Card(
        modifier = Modifier
            .size(128.dp)
            .padding(4.dp)
            .clickable {
                Log.d("Teste", "Hello")
            }
    ) {
        IconButton(
            onClick = {},
            modifier = Modifier
                .background(Color.Black)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Load more gifs",
                    tint = Color.White,
                    modifier = Modifier
                        .size(40.dp)
                )
                Text(
                    "Load more...",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 15.sp
                    )
                )
            }
        }
    }
}