package com.formation.seriestracker.di

import com.formation.seriestracker.domain.repository.TvShowRepository
import com.formation.seriestracker.domain.repository.FakeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTvShowRepository(): TvShowRepository {
        return FakeRepository() // On donne le faux pour l'instant
    }
}