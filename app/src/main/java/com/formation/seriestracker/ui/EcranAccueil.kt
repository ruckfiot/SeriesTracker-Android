package com.formation.seriestracker.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun EcranAccueil(viewModel: TvShowViewModel) {
    // Observation de l'état via StateFlow
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when {
            // État de chargement : CircularProgressIndicator centré
            uiState.isLoading -> {
                CircularProgressIndicator()
            }

            // État d'erreur : Message d'erreur et bouton Réessayer
            uiState.errorMessage != null -> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = uiState.errorMessage ?: "Une erreur est survenue.",
                        color = MaterialTheme.colorScheme.error,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { viewModel.reessayer() }) { // Appel de la fonction exposée par le ViewModel
                        Text("Réessayer")
                    }
                }
            }

            // État de succès : LazyColumn avec les CarteSerie
            uiState.tvShows.isNotEmpty() -> { // Assumant que Membre A a nommé la liste 'tvShows'
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(uiState.tvShows) { tvShow ->
                        CarteSerie(tvShow = tvShow)
                    }
                }
            }
        }
    }
}