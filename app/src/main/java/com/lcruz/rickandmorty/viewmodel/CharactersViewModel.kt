package com.lcruz.rickandmorty.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lcruz.rickandmorty.model.Character
import com.lcruz.rickandmorty.repository.CharactersRepository
import kotlinx.coroutines.launch

class CharactersViewModel(val repository: CharactersRepository) : ViewModel() {
    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> = _characters
    val error: MutableLiveData<String> = MutableLiveData()

    fun getCharacters() {
        viewModelScope.launch {
            try {
                val response = repository.getCharacters()
                _characters.value = response.characters
            } catch (e: Exception) {
                error.value = e.message
            }
        }
    }
}