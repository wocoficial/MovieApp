package br.dev.woc.movieapp.core.data.remote

import br.dev.woc.movieapp.core.data.remote.response.MovieDetailResponse
import br.dev.woc.movieapp.core.data.remote.response.MovieResponse
import br.dev.woc.movieapp.core.data.remote.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("page") page: Int): MovieResponse

    @GET("search/multi")
    suspend fun searchMovie(
        @Query("page") page: Int,
        @Query("query") query: String
    ): SearchResponse

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") movieId: Int): MovieDetailResponse

    @GET("movie/{movie_id}/similar")
    suspend fun getMovieSimilar(
        @Query("page") page: Int,
        @Query("query") query: String
    ): MovieResponse
}