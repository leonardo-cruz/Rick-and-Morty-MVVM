package com.lcruz.rickandmorty.repository

import com.lcruz.rickandmorty.model.CharactersResponse

interface CharactersRepository {

    suspend fun getCharacters(): CharactersResponse
}