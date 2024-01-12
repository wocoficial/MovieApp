package br.dev.woc.movieapp.search_movie_feature.domain.source

import br.dev.woc.movieapp.core.MovieSearchPagingSource
import br.dev.woc.movieapp.core.data.remote.MovieService
import br.dev.woc.movieapp.core.data.remote.response.SearchResponse
import br.dev.woc.movieapp.search_movie_feature.domain.source.MovieSearchRemoteDataSource
import javax.inject.Inject

class MovieSearchRemoteDataSourceImpl @Inject constructor(
    private val service: MovieService
) : MovieSearchRemoteDataSource {
    override fun getSearchMoviesPagingSource(query: String): MovieSearchPagingSource {
        return MovieSearchPagingSource(query = query, remoteDataSource = this)
    }

    override suspend fun getSearchMovies(page: Int, query: String): SearchResponse {
        return service.searchMovie(page = page, query = query)
    }


}