package edu.iesam.aad_repaso.feature.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(vararg movie: MovieEntity)

    @Query("SELECT * FROM $MOVIE_TABLE")
    fun findAll(): List<MovieEntity>

}