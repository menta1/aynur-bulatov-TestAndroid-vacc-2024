package com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.data

import com.example.aynur_bulatov_testandroid_vacc_2024.db.ShopDao
import com.example.aynur_bulatov_testandroid_vacc_2024.db.ShopProdEntity
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ShopRepositoryImpl @Inject constructor(
    private val shopDao: ShopDao
) : ShopRepository {
    override fun getAll(): Flow<List<ProductModel>> {
        return shopDao.getAllNotBuy().map { list ->
            list.map {
                ProductModel(
                    id = it.id,
                    name = it.name,
                    category = it.category,
                    thumbnail = it.thumbnail,
                    price = it.price,
                    description = it.description,
                    rating = it.rating
                )
            }
        }
    }

    override fun buyAll(list: List<ProductModel>) {
        list.forEach {
            shopDao.addShopProd(
                ShopProdEntity(
                    id = it.id,
                    name = it.name,
                    category = it.category,
                    thumbnail = it.thumbnail,
                    price = it.price,
                    description = it.description,
                    rating = it.rating,
                    isBayed = true
                )
            )
        }
    }
}