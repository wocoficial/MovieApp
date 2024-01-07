package br.dev.woc.movieapp.movie_popular_feature.presentation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.paging.compose.collectAsLazyPagingItems
import br.dev.woc.movieapp.R
import br.dev.woc.movieapp.core.util.UtilFuctions
import br.dev.woc.movieapp.movie_popular_feature.presentation.components.MovieContent
import br.dev.woc.movieapp.movie_popular_feature.presentation.state.MoviePopularState
import br.dev.woc.movieapp.ui.theme.black
import br.dev.woc.movieapp.ui.theme.white

@Composable
fun MoviePopularScreen(
    uiState: MoviePopularState,
    navigateToDetailMovie: (Int) -> Unit
) {
    val movies = uiState.movies.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.popular_movies),
                        color = white
                    )
                },
                backgroundColor = black
            )

        },
        content = { paddingValues ->
            MovieContent(pagingMovies = movies,
                paddingValues = paddingValues,
                onClick = { movieId ->
                    UtilFuctions.logInfo("MOVIE_ID", movieId.toString())
                    navigateToDetailMovie(movieId)
                })
        }
    )

}