package com.example.aynur_bulatov_testandroid_vacc_2024.di

import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.NetworkClient
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.NetworkClientImpl
import com.example.aynur_bulatov_testandroid_vacc_2024.features.network.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    const val BASE_URL = "https://dummyjson.com"

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideProductApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    @Provides
    fun provideNetworkClient(productApi: ProductApi): NetworkClient {
        return NetworkClientImpl(productApi)
    }
}