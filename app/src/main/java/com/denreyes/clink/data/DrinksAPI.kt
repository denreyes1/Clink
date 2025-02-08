package com.denreyes.clink.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinksAPI {

    @GET("filter.php")
    suspend fun fetchDrinkByCategory(
        @Query("c") category: String,
    ): Response<DrinkResponse>

}