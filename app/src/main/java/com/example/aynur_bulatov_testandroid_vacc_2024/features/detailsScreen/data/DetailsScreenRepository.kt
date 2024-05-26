package com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.data

import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel

interface DetailsScreenRepository {
    suspend fun getDetails(id: Int): ProductModel
    suspend fun addToShopCart(id: Int)
    suspend fun clear()
}