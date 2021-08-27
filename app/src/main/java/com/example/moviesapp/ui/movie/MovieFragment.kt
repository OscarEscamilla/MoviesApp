package com.example.moviesapp.ui.movie

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.moviesapp.core.Resource
import com.example.moviesapp.data.remote.MovieDataSource
import com.example.moviesapp.databinding.FragmentMovieBinding
import com.example.moviesapp.presentation.MovieViewModel
import com.example.moviesapp.presentation.VMFactory
import com.example.moviesapp.repository.MovieRepositoryImpl
import com.example.moviesapp.repository.RetrofitClient


class MovieFragment : Fragment() {


    private lateinit var binding: FragmentMovieBinding

    private val viewModel by viewModels<MovieViewModel> { VMFactory(MovieRepositoryImpl(
        MovieDataSource(RetrofitClient.webservice)
    )) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchScreenMovies.observe(viewLifecycleOwner, { result ->
            when(result){
                is Resource.Loading -> {
                    Log.d("LiveData2", "Loading...")
                }
                is Resource.Succes -> {
                    Log.d("LiveData2", "${result.data.first.results}")
                    Log.d("LiveData2", "${result.data.second.results}")
                    Log.d("LiveData2", "${result.data.third.results}")
                }
                is Resource.Failure -> {
                    Log.d("LiveData2", "${result.exception}")
                }
            }
        })





    }




}