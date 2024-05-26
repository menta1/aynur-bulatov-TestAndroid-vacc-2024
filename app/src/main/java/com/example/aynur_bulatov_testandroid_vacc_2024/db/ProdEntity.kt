package com.example.aynur_bulatov_testandroid_vacc_2024.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel

@Entity(tableName = "prod_table")
data class ProdEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val category: String,
    val thumbnail: String,
    val price: String,
    val description: String,
    val rating: String,
)

fun ProdEntity.asProdModel() = ProductModel(
    id, name, category, thumbnail, price, description, rating
)

fun ProdEntity.asShopModel() = ShopProdEntity(
    id, name, category, thumbnail, price, description, rating
)
