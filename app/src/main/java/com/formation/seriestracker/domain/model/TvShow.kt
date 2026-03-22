package com.formation.seriestracker.domain.model

data class TvShow(
    val id: Int,
    val name: String,
    val network: String,
    val status: String,
    val imageUrl: String,
    val country: String
)
fun com.formation.seriestracker.data.remote.dto.TvShowDto.toDomain(): TvShow =
    TvShow(
        id = this.id,
        name = this.name,
        network = this.network,
        status = this.status,
        imageUrl = this.imageThumbnailPath,
        country = "Inconnu"
    )