package com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto

import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("category") val category: String,
    @SerializedName("price") val price: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("rating") val rating: String,
) {
    fun toProduct(): ProductModel = ProductModel(
        id = id,
        name = title,
        category = category,
        thumbnail = thumbnail,
        price = price,
        description = description,
        rating = rating
    )
}
