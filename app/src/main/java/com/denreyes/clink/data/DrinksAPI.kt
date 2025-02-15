package com.denreyes.clink.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksAPI {

    @GET("filter.php")
    suspend fun fetchDrinksByCategory(
        @Query("c") category: String,
    ): Response<DrinkResponse>

    @GET("filter.php")
    suspend fun fetchDrinksByIngredient(
        @Query("i") ingredient: String,
    ): Response<DrinkResponse>


    @GET("lookup.php")
    suspend fun fetchDrinkById(
        @Query("i") id: String,
    ): Response<DrinkResponse>

}