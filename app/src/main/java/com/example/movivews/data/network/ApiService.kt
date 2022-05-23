package com.example.movivews.data.network

import com.example.movivews.data.models.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    //инпоинт возврашает весь список фильмов
    @GET("shows/1")
    suspend fun getAllMovies():Response<List<Movies>>

}