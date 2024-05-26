package com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.data

import com.example.aynur_bulatov_testandroid_vacc_2024.db.ProductDao
import com.example.aynur_bulatov_testandroid_vacc_2024.db.ShopDao
import com.example.aynur_bulatov_testandroid_vacc_2024.db.asProdModel
import com.example.aynur_bulatov_testandroid_vacc_2024.db.asShopModel
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import javax.inject.Inject

class DetailsScreenRepositoryImpl @Inject constructor(
    private val dao: ProductDao,
    private val shopDao: ShopDao

) : DetailsScreenRepository {
    override suspend fun getDetails(id: Int): ProductModel {
        return dao.getProd(id).asProdModel()
    }

    override suspend fun addToShopCart(id: Int) {
        shopDao.addShopProd(dao.getProd(id).asShopModel())
    }

    override suspend fun clear() {
        dao.clear()
    }
}