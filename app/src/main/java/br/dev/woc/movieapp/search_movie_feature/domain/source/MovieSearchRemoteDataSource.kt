package br.dev.woc.movieapp.search_movie_feature.domain.source

import br.dev.woc.movieapp.core.MovieSearchPagingSource
import br.dev.woc.movieapp.core.data.remote.response.SearchResponse

interface MovieSearchRemoteDataSource {
    fun getSearchMoviesPagingSource(query: String): MovieSearchPagingSource
    suspend fun getSearchMovies(page: Int, query: String): SearchResponse
}