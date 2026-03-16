package com.formation.seriestracker.data.remote.dto

import com.google.gson.annotations.SerializedName

data class TvShowDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("network") val network: String,
    @SerializedName("image_thumbnail_path") val imageThumbnailPath: String,
    @SerializedName("status") val status: String
)