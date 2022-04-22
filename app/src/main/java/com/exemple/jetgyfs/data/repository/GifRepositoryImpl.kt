package com.exemple.jetgyfs.data.repository

import com.exemple.jetgyfs.data.datasource.api.entity.ListGiffEntity
import com.exemple.jetgyfs.domain.repository.GifRepository
import com.exemple.jetgyfs.data.datasource.api.GifApi
import javax.inject.Inject

class GifRepositoryImpl
@Inject constructor( val gifApi: GifApi) : GifRepository {
    override suspend fun getSearchGifs(search: String): ListGiffEntity? {
        val gifs = gifApi.getSearchGifs(search = search).body()
        return gifs
    }

    override suspend fun getRandomGifs(limit: Int): ListGiffEntity? {
        val gifs = gifApi.getRandomGifs(
            limit = limit
        ).body()
        return gifs
    }
}