package br.dev.woc.movieapp.search_movie_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.dev.woc.movieapp.core.domain.model.MovieSearch
import br.dev.woc.movieapp.core.presentation.components.common.ErrorScreen
import br.dev.woc.movieapp.core.presentation.components.common.LoadingView
import br.dev.woc.movieapp.movie_popular_feature.presentation.components.MovieItem
import br.dev.woc.movieapp.search_movie_feature.presentation.MovieSearchEvent
import br.dev.woc.movieapp.ui.theme.black


@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    pagingMovies: LazyPagingItems<MovieSearch>,
    query: String,
    onSearch: (String) -> Unit,
    onEvent: (MovieSearchEvent) -> Unit,
    onDetail: (movieId: Int) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        SearchComponent(
            query = query,
            onSearch = {
                onSearch(it)
            },
            onQueryChangeEvent = {
                onEvent(it)
            },
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            items(pagingMovies.itemCount) { index ->
                val movie = pagingMovies[index]
                movie?.let {
                    MovieItem(
                        modifier = modifier,
                        voteAverage = it.voteAverage,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        onclick = { movieId ->
                            onDetail(movieId)

                        }
                    )
                }
            }
                pagingMovies.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            item(
                                span = {
                                    GridItemSpan(maxLineSpan)
                                }
                            ) {
                                LoadingView()
                            }
                        }

                        loadState.append is LoadState.Loading -> {
                            item(
                                span = {
                                    GridItemSpan(maxLineSpan)
                                }
                            ) {
                                LoadingView()
                            }
                        }

                        loadState.refresh is LoadState.Error -> {
                            item(
                                span = {
                                    GridItemSpan(maxLineSpan)
                                }
                            ) {
                                ErrorScreen(message = "Verifique a sua conexão com a internet",
                                    retry = {
                                        retry()
                                    })
                            }
                        }

                        loadState.append is LoadState.Error -> {
                            item(
                                span = {
                                    GridItemSpan(maxLineSpan)
                                }
                            ) {
                                ErrorScreen(message = "Verifique a sua conexão com a internet",
                                    retry = {
                                        retry()
                                    })
                            }
                        }
                    }
                }
            }
        }

    }


