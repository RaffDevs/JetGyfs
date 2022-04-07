package com.exemple.jetgyfs.presentation.shared

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.exemple.jetgyfs.presentation.giff.navigation.AppScreens

@Composable
fun AppDrawer(
    navController: NavController
) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val screens = AppScreens.values()

    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Menu",
                modifier = Modifier.padding(16.dp),
                style = TextStyle(
                    color = Color.White,
                    fontSize = 28.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        screens.forEach { item ->
            if (item.enableInDrawer) {
                AppDrawerItem(
                    screen = item,
                    isSelected = currentRoute == item.name,
                    onClick = {
                        Log.d("Nav", "Navagation")
                    }
                )
            }
        }
    }
}