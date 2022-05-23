package com.example.movivews.data.di

import com.example.movivews.data.network.ApiService
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class) // это компанент будет создан в единственом экземпляре
object AppModel {

    //базовый URL
    private const val BASE_URL = "https://api.tvmaze.com/"

    // сборка ретрофита
    private fun providerRetrofit():ApiService=
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
}