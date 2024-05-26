package com.example.aynur_bulatov_testandroid_vacc_2024.features.network

import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.Const.OK_RESPONSE
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.Const.SERVER_ERROR
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto.ProductRequest
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto.Response
import javax.inject.Inject

class NetworkClientImpl @Inject constructor(
    private val productApi: ProductApi
) : NetworkClient {
    override suspend fun getProducts(dto: ProductRequest): Response {
        return try {
            productApi.getProducts(dto.request).apply { resultCode = OK_RESPONSE }
        } catch (e: Exception) {
            e.printStackTrace()
            Response().apply { resultCode = SERVER_ERROR }
        }
    }
}