package com.denreyes.clink.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denreyes.clink.data.Drink
import com.denreyes.clink.data.DrinksRepository
import com.denreyes.clink.data.NetworkResult
import com.denreyes.clink.views.DrinksUIState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DrinksViewModel(
    private val drinksRepository: DrinksRepository
) : ViewModel() {
    val drinkUIState = MutableStateFlow(DrinksUIState())
    val selectedDrinkState = MutableStateFlow<Drink?>(null)
    val selectedCategory = MutableStateFlow("Gin")

    init {
        getDrinks(selectedCategory.value)
    }

    private fun getDrinks(category: String) {
        drinkUIState.value = DrinksUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = drinksRepository.getDrinksByIngredient(category)) {
                is NetworkResult.Success -> {
                    drinkUIState.update {
                        it.copy(isLoading = false, drinks = result.data)
                    }
                }

                is NetworkResult.Error -> {
                    drinkUIState.update {
                        it.copy(isLoading = false, error = result.error)
                    }
                }
            }
        }
    }

    fun setCategory(category: String) {
        selectedCategory.value = category
        getDrinks(category) // Fetch new drinks when category changes
    }


    fun getDrinkById(drinkId: String) {
        selectedDrinkState.value = null  // Reset state before fetching new drink
        CoroutineScope(Dispatchers.IO).launch {
            when (val result = drinksRepository.fetchDrinkById(drinkId)) {
                is NetworkResult.Success -> {
                    selectedDrinkState.value = result.data
                }

                is NetworkResult.Error -> {
                    Log.e("Clink/Error", "Failed to fetch drink: ${result.error}")
                }
            }
        }
    }
}
