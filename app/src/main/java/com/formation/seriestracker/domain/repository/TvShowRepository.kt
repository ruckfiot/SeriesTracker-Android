// domain/repository/TvShowRepository.kt
package com.formation.seriestracker.domain.repository

import com.formation.seriestracker.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
    // Une fonction qui renvoie un flux (Flow) de liste de séries
    fun getTvShows(): Flow<List<TvShow>>
}