package br.dev.woc.movieapp.search_movie_feature.data.repository


import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.dev.woc.movieapp.core.domain.model.MovieSearch
import br.dev.woc.movieapp.search_movie_feature.domain.repository.MovieSearchRepository
import br.dev.woc.movieapp.search_movie_feature.data.source.MovieSearchRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieSearchRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieSearchRemoteDataSource
) : MovieSearchRepository {
    override fun getSearchMovies(
        query: String,
        pagingConfig: PagingConfig
    ): Flow<PagingData<MovieSearch>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = {
                remoteDataSource.getSearchMoviesPagingSource(query = query)
            }
        ).flow
    }


}