package com.exemple.jetgyfs.presentation.giff.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exemple.jetgyfs.data.datasource.api.entity.DataEntity
import com.exemple.jetgyfs.domain.model.Giff
import com.exemple.jetgyfs.domain.repository.GifRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GiffViewModel
@Inject constructor(private val gifRepository: GifRepository): ViewModel(){
    private val listGifs = mutableStateListOf<Giff>()

    init {
        getTrendingGifs()
    }

    fun getAllGifs(): List<Giff> {
        return listGifs
    }

    fun getTrendingGifs() {
        viewModelScope.launch {
            val gifs = gifRepository.getRandomGifs()

            if (gifs != null) {
                listGifs.clear()

                gifs.data.forEach { giff ->
                    listGifs.add(
                        Giff(
                            giff.id,
                            giff.title,
                            giff.images.fixed_height.url
                        )
                    )
                }
            }
        }
    }

    fun getGifsBySearch(search: String) {
        viewModelScope.launch {
            val gifs = gifRepository.getSearchGifs(search)

            if (gifs != null) {
                listGifs.clear()

                gifs.data.forEach { giff ->
                    listGifs.add(
                        Giff(
                            giff.id,
                            giff.title,
                            giff.images.fixed_height.url
                        )
                    )
                }
            }
        }
    }
}