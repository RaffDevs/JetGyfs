package com.exemple.jetgyfs.domain.repository

import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff
import kotlinx.coroutines.flow.Flow

interface FavoriteGiffRepository {
    fun getAllFavoriteGiffs(): Flow<List<FavoriteGiff>>
    suspend fun saveFavoriteGiff(giff: FavoriteGiff)
    suspend fun removeFavoriteGiff(id: String)
}