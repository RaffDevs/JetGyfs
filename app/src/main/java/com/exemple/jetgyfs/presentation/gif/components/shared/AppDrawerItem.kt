package com.exemple.jetgyfs.presentation.gif.components.shared

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.exemple.jetgyfs.presentation.gif.navigation.AppScreens

@Composable
fun AppDrawerItem(
    screen: AppScreens,
    onClick: () -> Unit
) {
    Divider(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.DarkGray
    )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(start = 10.dp)
            .clickable {
                onClick.invoke()
            }
    ) {
        Icon(
            imageVector = screen.icon,
            contentDescription = screen.path,
            tint = Color.White,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = screen.path,
            fontSize = 18.sp,
            color = Color.White
        )
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.DarkGray
    )


}