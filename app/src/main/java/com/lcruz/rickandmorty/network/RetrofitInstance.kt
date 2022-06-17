package com.lcruz.rickandmorty.network

import com.lcruz.rickandmorty.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CharactersAPI by lazy {
        retrofit.create(CharactersAPI::class.java)
    }
}