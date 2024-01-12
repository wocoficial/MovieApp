package br.dev.woc.movieapp.movie_popular_feature.domain.source

import br.dev.woc.movieapp.core.MoviePagingSource
import br.dev.woc.movieapp.core.data.remote.MovieService
import br.dev.woc.movieapp.core.data.remote.response.MovieResponse
import javax.inject.Inject

class MoviePopularRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MoviePopularRemoteDataSource {
    override fun getPopularMoviesPagingSource(): MoviePagingSource {
        return MoviePagingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page = page)
    }

}