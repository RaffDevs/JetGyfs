package com.exemple.jetgyfs.data.repository

import android.util.Log
import com.exemple.jetgyfs.data.datasource.db.dao.FavoriteGiffDao
import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff
import com.exemple.jetgyfs.domain.repository.FavoriteGiffRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class FavoriteGiffRepositoryImpl
@Inject constructor(val favoriteGiffDao: FavoriteGiffDao) : FavoriteGiffRepository{
    override fun getAllFavoriteGiffs(): Flow<List<FavoriteGiff>> {
        return favoriteGiffDao.getFavoriteGiffs().flowOn(Dispatchers.IO).conflate()
    }

    override fun getFavoriteGiffsBySearch(search: String): Flow<List<FavoriteGiff>> {
        return favoriteGiffDao.getAllFavoriteGiffBySearch(search)
            .flowOn(Dispatchers.IO).conflate()
    }


    override fun getFavoriteGiffByTitle(title: String): Flow<FavoriteGiff?> {
        return favoriteGiffDao.getFavoriteGiffByTitle(title).flowOn(Dispatchers.IO).conflate()
    }

    override suspend fun saveGiffAsFavorite(giff: FavoriteGiff) {
        val favoriteGiff = getFavoriteGiffByTitle(giff.title).first()

        Log.d("EXISTE", "${favoriteGiff}")

        if (favoriteGiff != null) {
            Log.d("giff", "This giff already exists!")
        } else {
            favoriteGiffDao.saveFavoriteGiff(giff)
        }
    }

    override suspend fun removeFavoriteGiff(id: String) {
        favoriteGiffDao.deleteFavoriteGiff(id)
    }
}