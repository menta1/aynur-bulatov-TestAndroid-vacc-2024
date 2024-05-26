package com.example.aynur_bulatov_testandroid_vacc_2024.features.account.data

import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import kotlinx.coroutines.flow.Flow

interface AccountRepository {
    fun getAll(): Flow<List<ProductModel>>
    suspend fun clearDB()
}