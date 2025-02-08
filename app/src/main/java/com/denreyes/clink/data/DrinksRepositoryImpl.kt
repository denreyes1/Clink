package com.denreyes.clink.data

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DrinksRepositoryImpl(
    private val drinksAPI: DrinksAPI,
    private val dispatcher: CoroutineDispatcher
) : DrinksRepository {

    override suspend fun getDrinks(): NetworkResult<List<Drink>> {
        return withContext(dispatcher) {
            try {
                val response = drinksAPI.fetchDrinkByCategory("Cocktail")
                if (response.isSuccessful) {
                    response.body()?.let { drinkResponse ->
                        NetworkResult.Success(drinkResponse.drinks)
                    } ?: NetworkResult.Error("Response body is null")
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown API error"
                    Log.e("Clink/Error Network", "API Error: $errorMessage")
                    NetworkResult.Error(errorMessage)
                }
            } catch (e: Exception) {
                Log.e("Clink/Error Network", "Exception: ${e.message}", e)
                NetworkResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}
