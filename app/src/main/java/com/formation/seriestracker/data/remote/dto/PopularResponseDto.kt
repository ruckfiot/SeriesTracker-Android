package com.formation.seriestracker.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PopularResponseDto(
    @SerializedName("total")
    val total: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("tv_shows")
    val tvShows: List<TvShowDto>? = null
)