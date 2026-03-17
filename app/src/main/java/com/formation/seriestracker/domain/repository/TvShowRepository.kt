package com.formation.seriestracker.domain.repository

import com.formation.seriestracker.domain.model.TvShow

interface TvShowRepository {
    // Le Membre B devra coder cette fonction plus tard
    suspend fun getPopularShows(page: Int): List<TvShow>
}