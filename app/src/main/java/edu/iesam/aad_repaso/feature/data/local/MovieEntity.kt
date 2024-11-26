package edu.iesam.aad_repaso.feature.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

const val MOVIE_TABLE = "movie"
const val MOVIE_ID = "movie_id"

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = MOVIE_ID) val id: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "length") val length: String
)
