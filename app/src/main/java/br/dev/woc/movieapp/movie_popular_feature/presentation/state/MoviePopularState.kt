package br.dev.woc.movieapp.movie_popular_feature.presentation.state

import androidx.paging.PagingData
import br.dev.woc.movieapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

class MoviePopularState(
    var movies: Flow<PagingData<Movie>> = emptyFlow()
) {
}