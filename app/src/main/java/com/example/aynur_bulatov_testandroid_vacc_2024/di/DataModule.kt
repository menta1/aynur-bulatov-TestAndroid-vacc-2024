package com.example.aynur_bulatov_testandroid_vacc_2024.di

import android.content.Context
import androidx.room.Room
import com.example.aynur_bulatov_testandroid_vacc_2024.db.AppDatabase
import com.example.aynur_bulatov_testandroid_vacc_2024.db.ProductDao
import com.example.aynur_bulatov_testandroid_vacc_2024.db.ShopDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
    }

    @Provides
    @Singleton
    fun provideProductDao(database: AppDatabase): ProductDao {
        return database.productDao()
    }

    @Provides
    @Singleton
    fun provideShopDao(database: AppDatabase): ShopDao {
        return database.shopDao()
    }
}