package com.example.aynur_bulatov_testandroid_vacc_2024.di

import com.example.aynur_bulatov_testandroid_vacc_2024.features.account.data.AccountRepository
import com.example.aynur_bulatov_testandroid_vacc_2024.features.account.data.AccountRepositoryImpl
import com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.data.DetailsScreenRepository
import com.example.aynur_bulatov_testandroid_vacc_2024.features.detailsScreen.data.DetailsScreenRepositoryImpl
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.MainScreenRepository
import com.example.aynur_bulatov_testandroid_vacc_2024.features.mainScreen.data.MainScreenRepositoryImpl
import com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.data.ShopRepository
import com.example.aynur_bulatov_testandroid_vacc_2024.features.shoppingCart.data.ShopRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMainScreenRepository(mainScreenRepository: MainScreenRepositoryImpl): MainScreenRepository

    @Binds
    abstract fun bindDetailsScreenRepository(detailsScreenRepository: DetailsScreenRepositoryImpl): DetailsScreenRepository

    @Binds
    abstract fun bindShoppingCartRepository(shopRepository: ShopRepositoryImpl): ShopRepository

    @Binds
    abstract fun bindAccountRepository(accountRepository: AccountRepositoryImpl): AccountRepository
}