package com.example.aynur_bulatov_testandroid_vacc_2024.features.network

import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto.ProductRequest
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto.Response

interface NetworkClient {

    suspend fun getProducts(dto: ProductRequest): Response
}