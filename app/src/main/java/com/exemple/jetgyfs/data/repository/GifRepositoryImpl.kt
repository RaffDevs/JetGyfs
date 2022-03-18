package com.exemple.jetgyfs.data.repository

import com.exemple.jetgyfs.domain.model.ListGiff
import com.exemple.jetgyfs.domain.repository.GifRepository
import com.exemple.jetgyfs.data.data_source.api.GifApi
import javax.inject.Inject

class GifRepositoryImpl
@Inject constructor( val gifApi: GifApi) : GifRepository {
    override suspend fun getSearchGifs(search: String): ListGiff? {
        val gifs = gifApi.getSearchGifs(search = search).body()
        return gifs
    }

    override suspend fun getRandomGifs(): ListGiff? {
        val gifs = gifApi.getRandomGifs().body()
        return gifs
    }
}