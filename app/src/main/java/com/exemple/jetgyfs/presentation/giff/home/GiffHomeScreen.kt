package com.exemple.jetgyfs.presentation.giff.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.exemple.jetgyfs.presentation.components.GiffGridView
import com.exemple.jetgyfs.presentation.components.GiffSearchField
import com.exemple.jetgyfs.presentation.shared.AppScaffold

@Composable
fun GiffHomeScreen(
    viewModel: GiffViewModel = hiltViewModel(),
    navController: NavController
) {
    val scaffolState = rememberScaffoldState(
        rememberDrawerState(initialValue = DrawerValue.Closed)
    )

    val search = remember {
        mutableStateOf("")
    }
    
    val gifs = viewModel.getAllGifs()

    AppScaffold(
        scaffoldState = scaffolState,
        navController = navController
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
            Spacer(modifier = Modifier.height(20.dp))
            GiffGridView(
                navController = navController,
                giffs = gifs
            )
        }

    }


}
