package com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto

import com.google.gson.annotations.SerializedName

class ProductResponse(
    @SerializedName("products") val result: ArrayList<ProductDto>,
    @SerializedName("total") val total: Int,
    @SerializedName("skip") val skip: Int,
    @SerializedName("limit") val limit: Int,
) : Response() {

}