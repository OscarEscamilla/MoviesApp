package com.example.moviesapp.data.remote

import com.example.moviesapp.data.model.MoviesResponse
import com.example.moviesapp.repository.WebService
import com.example.moviesapp.utils.AppConstants

class MovieDataSource(private val webService: WebService) {


    suspend fun getUpcomingMovies(): MoviesResponse{
        return webService.getUpcomingMovies(AppConstants.API_KEY)
    }

    suspend fun getTopRatedMovies(): MoviesResponse{
        return webService.getTopRatedMovies(AppConstants.API_KEY)
    }

    suspend fun getPopularMovies(): MoviesResponse{
        return webService.getPopularMovies(AppConstants.API_KEY)
    }


}