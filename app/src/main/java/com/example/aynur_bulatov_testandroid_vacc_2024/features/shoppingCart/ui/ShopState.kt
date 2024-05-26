package com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.ui

import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel

sealed class ShopState {

    data object Default : ShopState()

    class Content(val result: List<ProductModel>) : ShopState()

    class Empty(val result: List<ProductModel> = listOf()) : ShopState()
}