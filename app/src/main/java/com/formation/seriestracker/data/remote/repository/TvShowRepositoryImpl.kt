package com.formation.seriestracker.data.remote.repository

import com.formation.seriestracker.data.remote.EpisodateApiService
import com.formation.seriestracker.domain.model.TvShow
import com.formation.seriestracker.domain.model.toDomain
import com.formation.seriestracker.domain.repository.TvShowRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowRepositoryImpl @Inject constructor(
    private val apiService: EpisodateApiService
) : TvShowRepository {

    override suspend fun getPopularShows(page: Int): List<TvShow> = withContext(Dispatchers.IO) {
        try {
            val response = apiService.getPopularShows(page)
            val tvShows = response.tvShows?.map { it.toDomain() } ?: emptyList()
            tvShows
        } catch (e: Exception) {
            emptyList()
        }
    }

    override fun getTvShows(): Flow<List<TvShow>> = flow {
        try {
            val response = apiService.getPopularShows(1)
            val tvShowsList = response.tvShows?.map { it.toDomain() } ?: emptyList()
            emit(tvShowsList)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }.flowOn(Dispatchers.IO)
}
