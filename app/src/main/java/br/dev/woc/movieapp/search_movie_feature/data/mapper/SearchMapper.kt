package br.dev.woc.movieapp.search_movie_feature.data.mapper

import br.dev.woc.movieapp.core.data.remote.model.SearchResult
import br.dev.woc.movieapp.core.domain.model.MovieSearch
import br.dev.woc.movieapp.core.util.toPostUrl

fun List<SearchResult>.toMovieSearch() = map { movieResult ->
    MovieSearch(
        id = movieResult.id,
        voteAverage = movieResult.voteAverage,
        imageUrl = movieResult.posterPath.toPostUrl() ?: ""
    )
}