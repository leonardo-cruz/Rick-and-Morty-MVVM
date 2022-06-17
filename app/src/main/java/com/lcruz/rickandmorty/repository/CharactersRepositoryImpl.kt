package com.lcruz.rickandmorty.repository

import com.lcruz.rickandmorty.model.CharactersResponse
import com.lcruz.rickandmorty.network.RetrofitInstance

class CharactersRepositoryImpl() : CharactersRepository {

    override suspend fun getCharacters(): CharactersResponse = RetrofitInstance.api.getCharacters()

}