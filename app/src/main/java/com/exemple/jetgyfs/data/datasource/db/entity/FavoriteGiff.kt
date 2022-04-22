package com.exemple.jetgyfs.data.datasource.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.exemple.jetgyfs.domain.model.Giff
import java.util.*

@Entity(tableName = "giff_table")
data class FavoriteGiff(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "url")
    val url: String
) {

    companion object {
        fun FavoriteGiff.toGiff() = Giff(
            id = id,
            title = title,
            url = url
        )
    }
}
