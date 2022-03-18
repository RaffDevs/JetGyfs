package com.exemple.jetgyfs.domain.repository

import com.exemple.jetgyfs.domain.model.ListGiff

interface GifRepository {
    suspend fun getRandomGifs(): ListGiff?
    suspend fun getSearchGifs(search: String): ListGiff?
}