package com.exemple.jetgyfs.presentation.giff.favorite

import android.widget.Space
import androidx.compose.foundation.layout.*
import androidx.compose.material.DrawerValue
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff.Companion.toGiff
import com.exemple.jetgyfs.presentation.components.GiffGridView
import com.exemple.jetgyfs.presentation.components.GiffSearchField
import com.exemple.jetgyfs.presentation.giff.details.GiffDetailViewModel
import com.exemple.jetgyfs.presentation.shared.AppScaffold


@Composable
fun GiffFavoriteScreen(
    detailViewModel: GiffDetailViewModel = hiltViewModel(),
    navController: NavController,
) {
    val scaffoldState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    val search = remember {
        mutableStateOf("")
    }

    val gifs = detailViewModel.favoriteGiffList.collectAsState().value

    AppScaffold(
        scaffoldState = scaffoldState,
        navController = navController,
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GiffSearchField(
                value = search.value,
                onValueChange = {text -> search.value = text},
                label = "Procurar",
                isTrailingButtonEnabled = true,
                trailingAction = {
                    detailViewModel.getFavoriteGiffsBySearch("")
                    search.value = ""
                },
                onImeAction = {
                    detailViewModel.getFavoriteGiffsBySearch(search.value)
                    search.value = ""
                }
            )
            Spacer(modifier = Modifier.height(20.dp))
            GiffGridView(
                navController = navController,
                giffs = gifs.map { it.toGiff() },
                defaultGrid = false
            )
        }
    }
}