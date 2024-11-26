package edu.iesam.aad_repaso.feature.domain

import org.koin.core.annotation.Single

@Single
class GetMoviesUseCase(private val repository: MovieRepository) {

    operator fun invoke(): List<Movie> {
        return repository.findAll()
    }

}