package com.exemple.jetgyfs.domain.gyfs.repository

import com.exemple.jetgyfs.domain.gyfs.model.ListGiff

interface GifRepository {
    suspend fun getRandomGifs(): ListGiff?
    suspend fun getSearchGifs(search: String): ListGiff?
}