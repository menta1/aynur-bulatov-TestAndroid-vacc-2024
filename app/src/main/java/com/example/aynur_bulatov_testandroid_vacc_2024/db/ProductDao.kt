package com.example.aynur_bulatov_testandroid_vacc_2024.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProd(prod: ProdEntity)

    @Query("SELECT * FROM prod_table WHERE id = :id")
    fun getProd(id: Int): ProdEntity

    @Query("DELETE FROM prod_table")
    fun clear()
}