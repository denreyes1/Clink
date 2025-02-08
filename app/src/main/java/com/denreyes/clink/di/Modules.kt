package com.denreyes.clink.di

import com.denreyes.clink.data.DrinksAPI
import com.denreyes.clink.data.DrinksRepository
import com.denreyes.clink.data.DrinksRepositoryImpl
import com.denreyes.clink.viewmodel.DrinksViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import org.koin.dsl.module
import retrofit2.Retrofit

val appModules = module {
    single<DrinksRepository> { DrinksRepositoryImpl(get(), get()) }
    single { Dispatchers.IO }
    single { DrinksViewModel(get()) }
    single {
        Retrofit.Builder()
            .addConverterFactory(
                Json.asConverterFactory(contentType = "application/json".
                toMediaType())
            )
            .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
            .build()
    }
    single { get<Retrofit>().create(DrinksAPI::class.java) }
}