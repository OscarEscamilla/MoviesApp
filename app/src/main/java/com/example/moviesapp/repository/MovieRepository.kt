package com.example.moviesapp.repository

import com.example.moviesapp.data.model.MoviesResponse

interface MovieRepository {

    suspend fun getUpcomingMovies(): MoviesResponse
    suspend fun getTopRatedMovies(): MoviesResponse
    suspend fun getPopularMovies(): MoviesResponse

}
