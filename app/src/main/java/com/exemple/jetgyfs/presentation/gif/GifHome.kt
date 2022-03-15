package com.exemple.jetgyfs.presentation.gif

import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.exemple.jetgyfs.presentation.gif.components.GiffGridView
import com.exemple.jetgyfs.presentation.gif.components.GiffSearchField

@Composable
fun GifHomeScreen( viewModel: GifViewModel = hiltViewModel() ) {
    val search = remember {
        mutableStateOf("")
    }

    val gifs = viewModel.getAllGifs()

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
            GiffSearchField(
                value = search.value,
                onValueChange = { text -> search.value = text },
                label = "Procurar",
                onImeAction = {
                    viewModel.getGifsBySearch(search.value)
                    search.value = ""
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            GiffGridView(giffs = gifs)
        }
    }
}
