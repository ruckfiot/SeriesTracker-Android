package com.formation.seriestracker.data.remote.dto

import com.formation.seriestracker.domain.model.TvShow
import com.google.gson.annotations.SerializedName

data class TvShowDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("network") val network: String,
    @SerializedName("image_thumbnail_path") val imageThumbnailPath: String,
    @SerializedName("status") val status: String,
    @SerializedName("country") val country: String
)
fun TvShowDto.toDomain(): TvShow =
    TvShow(
        id = this.id,
        name = this.name,
        network = this.network,
        status = this.status,
        imageUrl = this.imageThumbnailPath,
        country = this.country
    )