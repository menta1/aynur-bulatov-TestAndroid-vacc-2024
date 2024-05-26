package com.example.aynur_bulatov_testandroid_vacc_2024.features.account.data

import com.example.aynur_bulatov_testandroid_vacc_2024.db.ProductDao
import com.example.aynur_bulatov_testandroid_vacc_2024.db.ShopDao
import com.example.aynur_bulatov_testandroid_vacc_2024.db.asProdModel
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.ProductModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val dao: ShopDao,
    private val prod: ProductDao
) : AccountRepository {
    override fun getAll(): Flow<List<ProductModel>> {
        return dao.getAllIsBuyed().map { list -> list.map { it.asProdModel() } }
    }

    override suspend fun clearDB() {
        dao.clear()
        prod.clear()
    }
}