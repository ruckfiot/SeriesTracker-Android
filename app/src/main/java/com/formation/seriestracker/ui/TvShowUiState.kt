package com.formation.seriestracker.ui

import com.formation.seriestracker.domain.model.TvShow

sealed interface TvShowUiState {
    object Loading : TvShowUiState
    data class Success(val shows: List<TvShow>) : TvShowUiState
    data class Error(val message: String) : TvShowUiState
}