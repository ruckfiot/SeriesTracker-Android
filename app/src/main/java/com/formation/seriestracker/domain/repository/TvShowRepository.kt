package com.formation.seriestracker.domain.repository

import com.formation.seriestracker.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
    // Ta fonction (pour le Fake et l'UI actuelle)
    fun getTvShows(): Flow<List<TvShow>>

    // La fonction du Membre B (pour le futur Retrofit)
    suspend fun getPopularShows(page: Int): List<TvShow>
}