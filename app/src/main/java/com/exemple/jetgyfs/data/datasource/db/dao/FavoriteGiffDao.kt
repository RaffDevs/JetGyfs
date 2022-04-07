package com.exemple.jetgyfs.data.datasource.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteGiffDao {
    @Query("SELECT * FROM giff_table")
    fun getFavoriteGiffs(): Flow<List<FavoriteGiff>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveFavoriteGiff(giff: FavoriteGiff)

    @Query("DELETE FROM giff_table WHERE id = :id")
    suspend fun deleteFavoriteGiff(id: String)
}