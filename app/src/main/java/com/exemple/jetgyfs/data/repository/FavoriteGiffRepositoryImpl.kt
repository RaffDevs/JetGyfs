package com.exemple.jetgyfs.data.repository

import com.exemple.jetgyfs.data.datasource.db.dao.FavoriteGiffDao
import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff
import com.exemple.jetgyfs.domain.repository.FavoriteGiffRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoriteGiffRepositoryImpl
@Inject constructor(val favoriteGiffDao: FavoriteGiffDao) : FavoriteGiffRepository{
    override fun getAllFavoriteGiffs(): Flow<List<FavoriteGiff>> {
        return favoriteGiffDao.getFavoriteGiffs()
    }

    override suspend fun saveFavoriteGiff(giff: FavoriteGiff) {
        favoriteGiffDao.saveFavoriteGiff(giff)
    }

    override suspend fun removeFavoriteGiff(id: String) {
        favoriteGiffDao.deleteFavoriteGiff(id)
    }
}