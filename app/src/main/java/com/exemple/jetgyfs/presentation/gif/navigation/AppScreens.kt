package com.exemple.jetgyfs.presentation.gif.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

enum class AppScreens {
    HOME {
        override val path = "INICIO"
        override val icon = Icons.Default.Home
        override val enableInDrawer = true
    },

    FAVORITE {
        override val path = "FAVORITOS"
        override val icon = Icons.Default.Favorite
        override val enableInDrawer = true
    },

    DETAIL {
        override val path = "DETALHES"
        override val enableInDrawer = false
    };

    open val path: String = ""
    open val icon: ImageVector = Icons.Default.Category
    open val enableInDrawer: Boolean = false
}


