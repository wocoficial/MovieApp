package br.dev.woc.movieapp.core

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.dev.woc.movieapp.core.domain.model.Movie
import br.dev.woc.movieapp.movie_popular_feature.data.mapper.toMovie
import br.dev.woc.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import okio.IOException
import retrofit2.HttpException

class MoviePaggingSource constructor(
    private val remoteDataSource: MoviePopularRemoteDataSource
) :
    PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(LIMIT)

        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val pageNumber = params.key ?: 1

            val response = remoteDataSource.getPopularMovies(page = pageNumber)

            val movies = response.results

            LoadResult.Page(
                data = movies.toMovie(),
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (movies.isEmpty()) null else pageNumber + 1
            )
        } catch (exception: IOException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            exception.printStackTrace()
            return LoadResult.Error(exception)
        }
    }

    companion object {
        private const val LIMIT = 20
    }
}