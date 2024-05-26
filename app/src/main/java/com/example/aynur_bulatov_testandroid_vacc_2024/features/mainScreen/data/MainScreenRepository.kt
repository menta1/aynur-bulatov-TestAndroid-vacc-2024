package com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data

import kotlinx.coroutines.flow.Flow

interface MainScreenRepository {

    fun getProducts(): Flow<List<ProductModel>>

    suspend fun saveProd(product: ProductModel)
}