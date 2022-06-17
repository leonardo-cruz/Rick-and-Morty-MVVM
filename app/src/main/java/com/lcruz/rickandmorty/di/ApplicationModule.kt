package com.lcruz.rickandmorty.di

import com.lcruz.rickandmorty.adapter.CharactersAdapter
import com.lcruz.rickandmorty.repository.CharactersRepository
import com.lcruz.rickandmorty.repository.CharactersRepositoryImpl
import com.lcruz.rickandmorty.viewmodel.CharactersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ApplicationModule {

    val instanceModule = module {

        single { CharactersRepositoryImpl() as CharactersRepository }
        factory { CharactersAdapter(context = get()) }

        viewModel {
            CharactersViewModel(
                repository = get()
            )
        }
    }


}