package com.denreyes.clink.di

import com.denreyes.clink.data.DrinksRepository
import com.denreyes.clink.data.DrinksRepositoryImpl
import com.denreyes.clink.viewmodel.DrinksViewModel
import org.koin.dsl.module

val appModules = module {
    single<DrinksRepository> { DrinksRepositoryImpl() }
    single { DrinksViewModel(get()) }
}