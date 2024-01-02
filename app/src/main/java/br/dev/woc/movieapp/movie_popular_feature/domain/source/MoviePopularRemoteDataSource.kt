package br.dev.woc.movieapp.movie_popular_feature.domain.source

import br.dev.woc.movieapp.core.MoviePaggingSource
import br.dev.woc.movieapp.core.data.remote.response.MovieResponse

interface MoviePopularRemoteDataSource {
    fun getPopularMoviesPagingSource(): MoviePaggingSource
    suspend fun getPopularMovies(page: Int): MovieResponse
}