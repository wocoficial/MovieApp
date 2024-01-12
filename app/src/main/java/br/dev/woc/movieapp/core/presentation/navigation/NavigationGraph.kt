package br.dev.woc.movieapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.dev.woc.movieapp.movie_popular_feature.presentation.MoviePopularScreen
import br.dev.woc.movieapp.movie_popular_feature.presentation.MoviePopularViewModel
import br.dev.woc.movieapp.search_movie_feature.presentation.MovieSearchEvent
import br.dev.woc.movieapp.search_movie_feature.presentation.MovieSearchScreen
import br.dev.woc.movieapp.search_movie_feature.presentation.MovieSearchViewModel

@Composable
fun NavigationGraph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = BottomNavItem.MoviePopular.route
    ) {
        composable(BottomNavItem.MoviePopular.route) {
            val viewModel: MoviePopularViewModel = hiltViewModel()
            val uiState = viewModel.uiState

            MoviePopularScreen(uiState = uiState,
                navigateToDetailMovie = {

                })
        }
        composable(BottomNavItem.MovieSearch.route) {
            val viewModel: MovieSearchViewModel = hiltViewModel()
            val uiState = viewModel.uiState
            val onEvent: (MovieSearchEvent) -> Unit = viewModel::event
            val onFetch: (String) -> Unit = viewModel::fetch
            MovieSearchScreen(
                uiState = uiState,
                onEvent = onEvent,
                onFetch = onFetch,
                navigateToDetailMovie = {

                }


            )
        }
        composable(BottomNavItem.MovieFavorite.route) {

        }
    }

}