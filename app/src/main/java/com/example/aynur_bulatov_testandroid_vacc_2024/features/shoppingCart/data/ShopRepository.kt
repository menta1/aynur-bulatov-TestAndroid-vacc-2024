package com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.data

import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import kotlinx.coroutines.flow.Flow

interface ShopRepository {
    fun getAll(): Flow<List<ProductModel>>
    fun buyAll(list: List<ProductModel>)
}