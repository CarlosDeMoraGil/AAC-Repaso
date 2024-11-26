package edu.iesam.aad_repaso.feature.domain


interface MovieRepository {

    fun save(movie: Movie)
    fun findAll(): List<Movie>

}