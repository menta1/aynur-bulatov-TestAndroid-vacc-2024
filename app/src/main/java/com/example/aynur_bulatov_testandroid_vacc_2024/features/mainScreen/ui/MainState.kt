package com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.ui

import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel

sealed class MainState() {
    data object Loading : MainState()

    data class Content(val products: List<ProductModel>) : MainState()
}