package com.lcruz.rickandmorty.network

import com.lcruz.rickandmorty.model.CharactersResponse
import retrofit2.http.GET

interface CharactersAPI {

    @GET("character")
    suspend fun getCharacters(): CharactersResponse
}