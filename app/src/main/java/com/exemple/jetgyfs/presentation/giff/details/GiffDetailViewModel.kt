package com.exemple.jetgyfs.presentation.giff.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff
import com.exemple.jetgyfs.data.datasource.api.entity.DataEntity
import com.exemple.jetgyfs.domain.repository.FavoriteGiffRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GiffDetailViewModel
@Inject constructor(private val favoriteGiffRepository: FavoriteGiffRepository) : ViewModel(){
    private val listFavoriteGiffs = MutableStateFlow<List<FavoriteGiff>>(emptyList())
    val favoriteGiffList = listFavoriteGiffs.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            favoriteGiffRepository.getAllFavoriteGiffs().distinctUntilChanged()
                .collect { giffs ->
                    if (giffs.isNullOrEmpty()) {
                        Log.d("Empty", "Empty List")
                    } else {
                        listFavoriteGiffs.value = giffs
                    }
                }
        }
    }

    fun toFavoriteGiff(giff: DataEntity): FavoriteGiff {
        val favoriteGiff = FavoriteGiff(
            title = giff.title,
            url = giff.images.fixed_height.url
        )

        return favoriteGiff
    }

    fun getFavoriteGiffByTitle(title: String) : FavoriteGiff? {
        val giff = favoriteGiffList.value.find { it.title == title }

        if (giff != null) {
            return  giff
        }

        return null;
    }

    fun likeGiff(
        giff: FavoriteGiff,
        onSuccess: (success: String) -> Unit = {},
        onError: (error: String) -> Unit = {}
    ) {
        viewModelScope.launch {
            try {
                favoriteGiffRepository.saveFavoriteGiff(giff)
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