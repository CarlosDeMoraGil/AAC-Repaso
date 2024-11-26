package edu.iesam.aad_repaso.feature.data.local

import edu.iesam.aad_repaso.feature.domain.Movie

fun Movie.toEntity(): MovieEntity =
    MovieEntity(this.id, this.title, this.length)

fun MovieEntity.toDomain(): Movie =
    Movie(this.id, this.title, this.length)
