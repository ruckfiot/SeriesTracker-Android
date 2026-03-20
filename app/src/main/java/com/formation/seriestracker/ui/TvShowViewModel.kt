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

    // On initialise l'état avec isLoading = true
    private val _uiState = MutableStateFlow(TvShowUiState(isLoading = true))
    val uiState: StateFlow<TvShowUiState> = _uiState.asStateFlow()

    init {
        chargerSeries()
    }

    private fun chargerSeries() {
        // On remet l'état de chargement à zéro
        _uiState.update { it.copy(isLoading = true, errorMessage = null) }

        // On va chercher les données dans ton FakeRepository
        viewModelScope.launch {
            try {
                repository.getTvShows().collect { series ->
                    // On met à jour l'état avec la liste des séries !
                    _uiState.update {
                        it.copy(isLoading = false, tvShows = series)
                    }
                }
            } catch (e: Exception) {
                // S'il y a un souci, on affiche le message d'erreur
                _uiState.update {
                    it.copy(isLoading = false, errorMessage = "Impossible de charger les séries")
                }
            }
        }
    }

    // La fonction appelée par le bouton "Réessayer" de ton EcranAccueil
    fun reessayer() {
        chargerSeries()
    }
}