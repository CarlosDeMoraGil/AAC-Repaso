package edu.iesam.aad_repaso.app.di

import android.content.Context
import androidx.room.Room
import edu.iesam.aad_repaso.app.data.local.MovieDataBase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan
class LocalModule {

    @Single
    fun provideDataBase(context: Context): MovieDataBase {
        val db = Room.databaseBuilder(
            context,
            MovieDataBase::class.java,
            "Movie-db"
        )
        db.fallbackToDestructiveMigration()
        return db.build()
    }

}