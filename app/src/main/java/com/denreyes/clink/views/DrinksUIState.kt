package com.denreyes.clink.views

import com.denreyes.clink.data.Drink

data class DrinksUIState (
        val isLoading: Boolean = false,
        val drinks: List<Drink> = emptyList(),
        val error: String? = null
    )