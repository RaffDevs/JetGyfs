package com.exemple.jetgyfs.infra

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exemple.jetgyfs.data.datasource.db.dao.FavoriteGiffDao
import com.exemple.jetgyfs.data.datasource.db.entity.FavoriteGiff

@Database(
    entities = [FavoriteGiff::class],
    version = 2
)
abstract class GiffDatabase : RoomDatabase() {
    abstract fun giffDao(): FavoriteGiffDao
}