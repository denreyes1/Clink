package com.denreyes.clink.data

import android.util.Log
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DrinksRepositoryImpl(
    private val drinksAPI: DrinksAPI,
    private val dispatcher: CoroutineDispatcher
) : DrinksRepository {

    override suspend fun getDrinksByCategory(category: String): NetworkResult<List<Drink>> {
        return withContext(dispatcher) {
            try {
                val response = drinksAPI.fetchDrinksByCategory(category)
                if (response.isSuccessful) {
                    response.body()?.let { drinkResponse ->
                        NetworkResult.Success(drinkResponse.drinks)
                    } ?: NetworkResult.Error("Response body is null")
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown API error"
                    Log.e("Clink/Error Network/getDrinks", "API Error: $errorMessage")
                    NetworkResult.Error(errorMessage)
                }
            } catch (e: Exception) {
                Log.e("Clink/Error Network/getDrinks", "Exception: ${e.message}", e)
                NetworkResult.Error(e.message ?: "Unknown error")
            }
        }
    }

    override suspend fun getDrinksByIngredient(ingredient: String): NetworkResult<List<Drink>> {
        return withContext(dispatcher) {
            try {
                val response = drinksAPI.fetchDrinksByIngredient(ingredient)
                if (response.isSuccessful) {
                    response.body()?.let { drinkResponse ->
                        NetworkResult.Success(drinkResponse.drinks)
                    } ?: NetworkResult.Error("Response body is null")
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown API error"
                    Log.e("Clink/Error Network/getDrinks", "API Error: $errorMessage")
                    NetworkResult.Error(errorMessage)
                }
            } catch (e: Exception) {
                Log.e("Clink/Error Network/getDrinks", "Exception: ${e.message}", e)
                NetworkResult.Error(e.message ?: "Unknown error")
            }
        }
    }

    override suspend fun fetchDrinkById(id: String): NetworkResult<Drink> {
        return withContext(dispatcher) {
            try {
                val response = drinksAPI.fetchDrinkById(id)
                if (response.isSuccessful) {
                    response.body()?.drinks?.firstOrNull()?.let { drink ->
                        NetworkResult.Success(drink)
                    } ?: NetworkResult.Error("Drink not found")
                } else {
                    val errorMessage = response.errorBody()?.string() ?: "Unknown API error"
                    Log.e("Clink/Error Network/fetchDrinkById", "API Error: $errorMessage")
                    NetworkResult.Error(errorMessage)
                }
            } catch (e: Exception) {
                Log.e("Clink/Error Network/fetchDrinkById", "Exception: ${e.message}", e)
                NetworkResult.Error(e.message ?: "Unknown error")
            }
        }
    }
}