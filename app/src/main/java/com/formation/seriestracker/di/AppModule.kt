package com.formation.seriestracker.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import com.formation.seriestracker.data.remote.EpisodateApiService
import com.formation.seriestracker.data.remote.repository.TvShowRepositoryImpl
import com.formation.seriestracker.domain.repository.TvShowRepository

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://www.episodate.com/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideEpisodateApiService(retrofit: Retrofit): EpisodateApiService {
        return retrofit.create(EpisodateApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(apiService: EpisodateApiService): TvShowRepository {
        return TvShowRepositoryImpl(apiService)
    }
}