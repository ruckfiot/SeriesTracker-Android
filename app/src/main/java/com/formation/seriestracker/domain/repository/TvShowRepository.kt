package com.formation.seriestracker.domain.repository

import com.formation.seriestracker.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface TvShowRepository {
    suspend fun getPopularShows(page: Int): List<TvShow>
    fun getTvShows(): Flow<List<TvShow>>
}