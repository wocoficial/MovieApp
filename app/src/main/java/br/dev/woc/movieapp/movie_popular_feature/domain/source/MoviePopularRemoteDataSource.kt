package br.dev.woc.movieapp.movie_popular_feature.domain.source

import br.dev.woc.movieapp.core.MoviePagingSource
import br.dev.woc.movieapp.core.data.remote.response.MovieResponse

interface MoviePopularRemoteDataSource {
    fun getPopularMoviesPagingSource(): MoviePagingSource
    suspend fun getPopularMovies(page: Int): MovieResponse
}