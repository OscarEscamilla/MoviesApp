package com.example.moviesapp.repository

import com.example.moviesapp.data.model.MoviesResponse
import com.example.moviesapp.data.remote.MovieDataSource

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {


    override suspend fun getUpcomingMovies(): MoviesResponse = dataSource.getUpcomingMovies()


    override suspend fun getTopRatedMovies(): MoviesResponse = dataSource.getTopRatedMovies()


    override suspend fun getPopularMovies(): MoviesResponse = dataSource.getPopularMovies()


}