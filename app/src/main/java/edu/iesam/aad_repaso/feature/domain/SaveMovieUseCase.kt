package edu.iesam.aad_repaso.feature.domain

import org.koin.core.annotation.Single

@Single
class SaveMovieUseCase(private val repository: MovieRepository) {

    operator fun invoke(movie: Movie) {
        repository.save(movie)
    }

}