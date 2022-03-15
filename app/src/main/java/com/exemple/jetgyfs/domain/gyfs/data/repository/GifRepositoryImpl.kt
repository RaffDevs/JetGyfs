package com.exemple.jetgyfs.domain.gyfs.data.repository

import android.util.Log
import com.exemple.jetgyfs.domain.gyfs.model.ListGiff
import com.exemple.jetgyfs.domain.gyfs.repository.GifRepository
import com.exemple.jetgyfs.networking.GifApi
import javax.inject.Inject

class GifRepositoryImpl
@Inject constructor( val gifApi: GifApi ) : GifRepository{
    override suspend fun getSearchGifs(search: String): ListGiff? {
        val gifs = gifApi.getSearchGifs(search = search).body()
        return gifs
    }

    override suspend fun getRandomGifs(): ListGiff? {
        val gifs = gifApi.getRandomGifs().body()
        return gifs
    }
}