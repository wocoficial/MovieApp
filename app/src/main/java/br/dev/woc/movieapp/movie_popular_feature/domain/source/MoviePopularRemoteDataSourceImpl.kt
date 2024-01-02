package br.dev.woc.movieapp.movie_popular_feature.domain.source

import br.dev.woc.movieapp.core.MoviePaggingSource
import br.dev.woc.movieapp.core.data.remote.MovieService
import br.dev.woc.movieapp.core.data.remote.response.MovieResponse

class MoviePopularRemoteDataSourceImpl constructor(
    private val service: MovieService
) : MoviePopularRemoteDataSource {
    override fun getPopularMoviesPagingSource(): MoviePaggingSource {
        return MoviePaggingSource(this)
    }

    override suspend fun getPopularMovies(page: Int): MovieResponse {
        return service.getPopularMovies(page = page)
    }

}