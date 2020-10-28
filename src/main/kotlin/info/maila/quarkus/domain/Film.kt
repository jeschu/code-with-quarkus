package info.maila.quarkus.domain

import java.time.LocalDate

data class Film(
        val title: String,
        val episodeId: Int,
        val director: String,
        val releaseDate: LocalDate
)