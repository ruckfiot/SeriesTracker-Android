package com.formation.seriestracker.ui

import com.formation.seriestracker.domain.model.TvShow

data class TvShowUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val tvShows: List<TvShow> = emptyList()
)