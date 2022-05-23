package com.example.movivews.data.network

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    //получаем все фильмы из ApiService
    suspend fun getAllMovies() = apiService.getAllMovies()
}