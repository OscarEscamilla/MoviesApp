package com.example.moviesapp.presentation

import androidx.lifecycle.*
import com.example.moviesapp.core.Resource
import com.example.moviesapp.data.model.MoviesResponse
import com.example.moviesapp.repository.MovieRepository
import kotlinx.coroutines.Dispatchers


class MovieViewModel(private val repo: MovieRepository): ViewModel() {



    val fetchScreenMovies = liveData<Resource<Triple<MoviesResponse,MoviesResponse,MoviesResponse>>>(Dispatchers.IO){
        emit(Resource.Loading())
        try {
            emit(Resource.Succes(Triple(repo.getUpcomingMovies(), repo.getTopRatedMovies(), repo.getPopularMovies())))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }
    }



}


class VMFactory(private val repo: MovieRepository): ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java).newInstance(repo)
    }

}