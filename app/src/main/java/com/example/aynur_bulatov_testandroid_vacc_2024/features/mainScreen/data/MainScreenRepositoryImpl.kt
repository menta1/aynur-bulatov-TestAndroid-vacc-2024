package com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data

import android.content.Context
import com.example.aynur_bulatov_testandroid_vacc_2024.db.ProdEntity
import com.example.aynur_bulatov_testandroid_vacc_2024.db.ProductDao
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.Const.OK_RESPONSE
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.NetworkClient
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto.ProductDto
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto.ProductRequest
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.dto.ProductResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MainScreenRepositoryImpl @Inject constructor(
    private val networkClient: NetworkClient,
    private val dao: ProductDao,
    @ApplicationContext private val context: Context
) : MainScreenRepository {

    override fun getProducts(): Flow<List<ProductModel>> = flow {
        val result = networkClient.getProducts(
            ProductRequest(
                hashMapOf(
                    "limit" to "0"
                )
            )
        )

        when (result.resultCode) {
            OK_RESPONSE -> {
                emit((result as ProductResponse).result.map(ProductDto::toProduct))
            }

            else -> {
                emptyFlow<List<ProductModel>>()
            }
        }

    }

    override suspend fun saveProd(product: ProductModel) {
        dao.addProd(
            ProdEntity(
                id = product.id,
                name = product.name,
                category = product.category,
                thumbnail = product.thumbnail,
                price = product.price,
                description = product.description,
                rating = product.rating
            )
        )
    }
}