package com.example.aynur_bulatov_testandroid_vacc_2024.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addShopProd(prod: ShopProdEntity)

    @Query("SELECT * FROM shop_table WHERE id = :id")
    fun getProd(id: Int): ShopProdEntity

    @Query("SELECT * FROM shop_table")
    fun getAll(): Flow<List<ShopProdEntity>>

    @Query("SELECT * FROM shop_table WHERE isBayed = 0")
    fun getAllNotBuy(): Flow<List<ShopProdEntity>>

    @Query("SELECT * FROM shop_table WHERE isBayed = 1")
    fun getAllIsBuyed(): Flow<List<ShopProdEntity>>

    @Delete
    fun deleteBuyed(list: List<ShopProdEntity>)

    @Query("DELETE FROM shop_table")
    fun clear()
}