package com.example.moviesapp.repository


import com.example.moviesapp.data.model.MoviesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {


    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") api_key: String): MoviesResponse

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(@Query("api_key") apiKey: String): MoviesResponse

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MoviesResponse


}