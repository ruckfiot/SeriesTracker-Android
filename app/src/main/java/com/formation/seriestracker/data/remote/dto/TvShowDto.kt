package com.formation.seriestracker.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.formation.seriestracker.domain.model.TvShow

data class TvShowDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("network") val network: String,
    @SerializedName("image_thumbnail_path") val imageThumbnailPath: String,
    @SerializedName("status") val status: String
)


fun TvShowDto.toDomain(): TvShow {
    return TvShow(
        id = this.id,
        name = this.name,
        network = this.network,
        status = this.status,
        imageUrl = this.imageThumbnailPath,
        country = "Inconnu"
    )
}