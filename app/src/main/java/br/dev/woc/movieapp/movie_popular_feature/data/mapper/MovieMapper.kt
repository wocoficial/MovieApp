package br.dev.woc.movieapp.movie_popular_feature.data.mapper

import br.dev.woc.movieapp.core.data.remote.model.MovieResult
import br.dev.woc.movieapp.core.domain.model.Movie
import br.dev.woc.movieapp.core.util.toPostUrl

fun List<MovieResult>.toMovie() = map { movieResult ->
    Movie(
        id = movieResult.id,
        title = movieResult.title,
        voteAverage = movieResult.voteAverage,
        imageUrl = movieResult.posterPath.toPostUrl()
    )
}