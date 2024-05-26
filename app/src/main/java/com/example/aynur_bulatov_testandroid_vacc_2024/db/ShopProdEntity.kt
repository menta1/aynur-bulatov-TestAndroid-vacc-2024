package com.example.aynur_bulatov_testandroid_vacc_2024.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel

@Entity(tableName = "shop_table")
data class ShopProdEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val category: String,
    val thumbnail: String,
    val price: String,
    val description: String,
    val rating: String,
    val isBayed: Boolean = false
)

fun ShopProdEntity.asProdModel() = ProductModel(
    id, name, category, thumbnail, price, description, rating
)

