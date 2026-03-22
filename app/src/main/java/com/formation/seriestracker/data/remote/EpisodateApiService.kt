package com.formation.seriestracker.data.remote

import com.formation.seriestracker.data.remote.dto.PopularResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface EpisodateApiService {
    @GET("most-popular")
    suspend fun getPopularShows(
        @Query("page") page: Int = 1
    ): PopularResponseDto
}