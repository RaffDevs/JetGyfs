package com.exemple.jetgyfs.domain.repository

import com.exemple.jetgyfs.data.datasource.api.entity.ListGiffEntity

interface GifRepository {
    suspend fun getRandomGifs(limit: Int): ListGiffEntity?
    suspend fun getSearchGifs(search: String): ListGiffEntity?
}