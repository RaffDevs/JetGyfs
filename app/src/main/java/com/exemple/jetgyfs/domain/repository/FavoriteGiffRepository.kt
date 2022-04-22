package com.exemple.jetgyfs.domain.repository

import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff
import kotlinx.coroutines.flow.Flow

interface FavoriteGiffRepository {
    fun getAllFavoriteGiffs(): Flow<List<FavoriteGiff>>
    fun getFavoriteGiffsBySearch(title: String): Flow<List<FavoriteGiff>>
    fun getFavoriteGiffByTitle(title: String): Flow<FavoriteGiff?>
    suspend fun saveGiffAsFavorite(giff: FavoriteGiff)
    suspend fun removeFavoriteGiff(id: String)
}