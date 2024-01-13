package br.dev.woc.movieapp.search_movie_feature.di

import br.dev.woc.movieapp.core.data.remote.MovieService
import br.dev.woc.movieapp.search_movie_feature.data.repository.MovieSearchRepositoryImpl
import br.dev.woc.movieapp.search_movie_feature.domain.repository.MovieSearchRepository
import br.dev.woc.movieapp.search_movie_feature.data.source.MovieSearchRemoteDataSource
import br.dev.woc.movieapp.search_movie_feature.data.source.MovieSearchRemoteDataSourceImpl
import br.dev.woc.movieapp.search_movie_feature.domain.usecase.GetMovieSearchUseCase
import br.dev.woc.movieapp.search_movie_feature.domain.usecase.GetMovieSearchUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieSearchFeatureModule {
    @Provides
    @Singleton
    fun provideMovieSearchDataSource(service: MovieService): MovieSearchRemoteDataSource {
        return MovieSearchRemoteDataSourceImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieSearchRepository(remoteDataSource: MovieSearchRemoteDataSource): MovieSearchRepository {
        return MovieSearchRepositoryImpl(remoteDataSource = remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideGetMoviesSearchUseCase(movieSearchRepository: MovieSearchRepository): GetMovieSearchUseCase {
        return GetMovieSearchUseCaseImpl(repository = movieSearchRepository)
    }
}