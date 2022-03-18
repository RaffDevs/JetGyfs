package com.exemple.jetgyfs.infra

import androidx.room.Database
import androidx.room.RoomDatabase
import com.exemple.jetgyfs.data.data_source.db.FavoriteGiffDao
import com.exemple.jetgyfs.data.data_source.db.entity.FavoriteGiff

@Database(
    entities = [FavoriteGiff::class],
    version = 1
)
abstract class GiffDatabase : RoomDatabase() {
    abstract fun giffDao(): FavoriteGiffDao

}