package com.exemple.jetgyfs.presentation.giff.details

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff
import com.exemple.jetgyfs.data.datasource.api.entity.DataEntity
import com.exemple.jetgyfs.domain.model.Giff
import com.exemple.jetgyfs.domain.repository.FavoriteGiffRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GiffDetailViewModel
@Inject constructor(private val favoriteGiffRepository: FavoriteGiffRepository) : ViewModel(){
    private val listFavoriteGiffs = MutableStateFlow<List<FavoriteGiff>>(emptyList())
    private var currentGiff = MutableStateFlow<FavoriteGiff?>(null)
    val favoriteGiffList = listFavoriteGiffs.asStateFlow()
    val currentFavoriteGiff = currentGiff.asStateFlow()


    init {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteGiffRepository.getAllFavoriteGiffs().distinctUntilChanged()
                .collect { giffs ->
                    if (giffs.isNullOrEmpty()) {
                        listFavoriteGiffs.value = emptyList()
                    } else {
                        listFavoriteGiffs.value = giffs
                    }
                }
        }
    }

    fun toFavoriteGiff(giff: Giff): FavoriteGiff {
        val favoriteGiff = FavoriteGiff(
            title = giff.title,
            url = giff.url
        )

        return favoriteGiff
    }


    fun getFavoriteGiffByTitle(title: String) {
        viewModelScope.launch {
            currentGiff.value = favoriteGiffRepository.getFavoriteGiffByTitle(title).first()
        }
    }

    fun getFavoriteGiffsBySearch(search: String) {
        viewModelScope.launch {
            favoriteGiffRepository.getFavoriteGiffsBySearch(search)
                .distinctUntilChanged().collect { giffs ->
                    if (giffs.isNullOrEmpty()) {
                        listFavoriteGiffs.value = emptyList()
                    } else {
                        listFavoriteGiffs.value = giffs
                    }
                }

        }
    }

    fun likeGiff(
        giff: FavoriteGiff,
        onSuccess: (success: String) -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                favoriteGiffRepository.saveGiffAsFavorite(giff)
                currentGiff.value = giff
                onSuccess("Giff adicionado aos favoritos")
            } catch (error: Exception) {
                onError(error.toString())
            }
        }
    }

    fun unlikeGiff(
        id: String,
        onSuccess: (success: String) -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                favoriteGiffRepository.removeFavoriteGiff(id)
                onSuccess("Giff removido dos favoritos")
            } catch (error: Exception) {
                onError(error.toString())
            }
        }
    }
}