package edu.iesam.aad_repaso.feature.di

import edu.iesam.aad_repaso.app.data.local.MovieDataBase
import edu.iesam.aad_repaso.feature.data.local.MovieDao
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class MovieModule {

    @Single
    fun provideDao(db: MovieDataBase): MovieDao {
        return db.movieDao()
    }

}