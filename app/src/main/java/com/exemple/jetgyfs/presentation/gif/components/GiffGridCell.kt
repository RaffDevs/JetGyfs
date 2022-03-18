package com.exemple.jetgyfs.presentation.gif.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.exemple.jetgyfs.domain.model.Data
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GiffGridCell(
    giff: Data,
    onClickCell: (giff: Data) -> Unit
) {
    GlideImage(
        modifier = Modifier
            .size(128.dp)
            .padding(4.dp)
            .clickable {
               onClickCell(giff)
            },
        imageModel = giff.images.fixed_height.url,
        contentDescription = giff.title,
        loading = {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    )


}