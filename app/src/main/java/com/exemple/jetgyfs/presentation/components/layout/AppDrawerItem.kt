package com.exemple.jetgyfs.presentation.shared

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
import com.exemple.jetgyfs.presentation.giff.navigation.AppScreens

@Composable
fun AppDrawerItem(
    screen: AppScreens,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val selectedColor = if(isSelected) MaterialTheme.colors.primary else Color.White
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
            tint = selectedColor,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(7.dp))
        Text(
            text = screen.path,
            fontSize = 18.sp,
            color = selectedColor
        )
    }
    Divider(
        modifier = Modifier
            .fillMaxWidth(),
        color = Color.DarkGray
    )


}