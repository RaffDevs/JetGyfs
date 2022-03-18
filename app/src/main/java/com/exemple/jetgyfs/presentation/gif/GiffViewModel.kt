package com.exemple.jetgyfs.presentation.gif

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exemple.jetgyfs.domain.model.Data
import com.exemple.jetgyfs.domain.repository.GifRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GiffViewModel
@Inject constructor(private val gifRepository: GifRepository): ViewModel(){
    private val listGifs = mutableStateListOf<Data>()

    init {
        getTrendingGifs()
    }

    fun getAllGifs(): List<Data> {
        return listGifs
    }

    fun getTrendingGifs() {
        viewModelScope.launch {
            val gifs = gifRepository.getRandomGifs()

            if (gifs != null) {
                listGifs.clear()
                listGifs.addAll(gifs.data)
            }
        }
    }

    fun getGifsBySearch(search: String) {
        viewModelScope.launch {
            val gifs = gifRepository.getSearchGifs(search)

            if (gifs != null) {
                listGifs.clear()
                listGifs.addAll(gifs.data)
            }
        }
    }
}