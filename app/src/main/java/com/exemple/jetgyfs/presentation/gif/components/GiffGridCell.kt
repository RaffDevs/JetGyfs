package com.exemple.jetgyfs.presentation.gif.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.exemple.jetgyfs.domain.gyfs.model.Data
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun GiffGridCell(giff: Data) {
    GlideImage(
        modifier = Modifier
            .size(128.dp)
            .padding(4.dp),
        imageModel = giff.images.fixed_height.url,
        contentDescription = giff.title,
        loading = {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    )


}