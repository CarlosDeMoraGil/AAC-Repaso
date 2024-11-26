package edu.iesam.aad_repaso.feature.data.local

import edu.iesam.aad_repaso.feature.domain.Movie
import org.koin.core.annotation.Single

@Single
class MovieLocalDbDataSource(private val dao: MovieDao) {

    fun save(movie: Movie) {
        dao.save(movie.toEntity())
    }

    fun findAll(): List<Movie> {
        val moviesEntity = dao.findAll()
        val moviesDomain = moviesEntity.map {
            it.toDomain()
        }

        return moviesDomain
    }

}