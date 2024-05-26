package com.example.aynur_bulatov_testandroid_vacc_2024.features.network

import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto.ProductResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ProductApi {
    @GET("/products")
    suspend fun getProducts(@QueryMap options: Map<String, String>): ProductResponse
}