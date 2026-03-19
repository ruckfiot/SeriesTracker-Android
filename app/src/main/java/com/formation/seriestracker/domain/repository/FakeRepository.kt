// domain/repository/FakeRepository.kt
package com.formation.seriestracker.domain.repository

import com.formation.seriestracker.domain.model.TvShow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeRepository @Inject constructor() : TvShowRepository {

    // On crée une liste factice de séries
    private val fakeShows = listOf(
        TvShow(
            id = 1,
            name = "Game of Thrones",
            network = "HBO",
            status = "Ended",
            imageUrl = "https://static.episodes.fm/images/shows/game-of-thrones.jpg",
            country = "USA" // Correction country ici
        ),
        TvShow(
            id = 2,
            name = "Breaking Bad",
            network = "AMC",
            status = "Ended",
            imageUrl = "https://static.episodes.fm/images/shows/breaking-bad.jpg",
            country = "USA"
        ),
        TvShow(
            id = 3,
            name = "Stranger Things",
            network = "Netflix",
            status = "Running",
            imageUrl = "https://static.episodes.fm/images/shows/stranger-things.jpg",
            country = "USA"
        )
    )

    // On implémente la fonction pour renvoyer cette liste dans un Flow
    override fun getTvShows(): Flow<List<TvShow>> = flow {
        emit(fakeShows)
    }
}