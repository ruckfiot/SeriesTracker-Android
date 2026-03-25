package com.formation.seriestracker.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.formation.seriestracker.domain.repository.TvShowRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TvShowViewModel @Inject constructor(
    private val repository: TvShowRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(TvShowUiState(isLoading = true))
    val uiState: StateFlow<TvShowUiState> = _uiState.asStateFlow()

    init { chargerSeries() }

    private fun chargerSeries() {
        _uiState.update { it.copy(isLoading = true, errorMessage = null) }

        viewModelScope.launch {
            try {
                repository.getTvShows().collect { series ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            tvShows = series,
                            errorMessage = null
                        )
                    }
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        tvShows = emptyList(),
                        errorMessage = "Erreur réseau: ${e.message}"
                    )
                }
            }
        }
    }

    fun reessayer() {
        chargerSeries()
    }
}