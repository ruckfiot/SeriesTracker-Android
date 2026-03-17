package com.formation.seriestracker.domain.model

data class TvShow(
    val id: Int,
    val name: String,
    val network: String,
    val status: String,
    val imageUrl: String
)