package edu.iesam.aad_repaso.feature.data

import edu.iesam.aad_repaso.feature.data.local.MovieLocalDbDataSource
import edu.iesam.aad_repaso.feature.domain.Movie
import edu.iesam.aad_repaso.feature.domain.MovieRepository
import org.koin.core.annotation.Single

@Single
class MovieDataRepository(private val localDbDataSource: MovieLocalDbDataSource) : MovieRepository {


    override fun save(movie: Movie) {
        localDbDataSource.save(movie)
    }

    override fun findAll(): List<Movie> {
        return localDbDataSource.findAll()
    }


}