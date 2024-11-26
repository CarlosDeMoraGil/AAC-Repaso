package edu.iesam.aad_repaso.feature.domain


interface MovieRepository {

    fun findAll(): List<Movie>

}