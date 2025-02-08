package com.denreyes.clink.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.denreyes.clink.data.Drink
import com.denreyes.clink.data.DrinksRepository
import com.denreyes.clink.data.DrinksRepositoryImpl
import com.denreyes.clink.data.NetworkResult
import com.denreyes.clink.views.DrinksUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DrinksViewModel(
    private val drinksRepository: DrinksRepository
) : ViewModel() {
    val drinkUIState = MutableStateFlow(DrinksUIState())

    init {
        getPets()
    }

    private fun getPets() {
        drinkUIState.value = DrinksUIState(isLoading = true)
        viewModelScope.launch {
            when (val result = drinksRepository.getDrinks()) {
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

    fun getDrinkById(drinkId: String): Drink? {
//        return drinksRepository.getDrinks().find { it.idDrink == drinkId }
        return null
    }
}
