package com.formation.seriestracker.ui

import com.formation.seriestracker.domain.model.TvShow

// Les 3 variables exactes que ton EcranAccueil réclame !
data class TvShowUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val tvShows: List<TvShow> = emptyList()
)