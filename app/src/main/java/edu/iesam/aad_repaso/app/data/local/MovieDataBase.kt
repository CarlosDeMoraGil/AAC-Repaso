package edu.iesam.aad_repaso.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import edu.iesam.aad_repaso.feature.data.local.MovieDao
import edu.iesam.aad_repaso.feature.data.local.MovieEntity

@Database(entities = [MovieEntity::class], version = 1, exportSchema = false)
abstract class MovieDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

}