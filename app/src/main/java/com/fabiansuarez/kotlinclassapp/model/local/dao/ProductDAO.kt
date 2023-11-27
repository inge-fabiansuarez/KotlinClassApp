package com.fabiansuarez.kotlinclassapp.model.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.fabiansuarez.kotlinclassapp.model.entity.Product

@Dao
interface ProductDAO {
    @Query("select * from products")
    fun getAll(): List<Product>

    @Query("select * from products where `key`=:keyValue")
    fun getByKey(keyValue: Int): Product

    @Insert
    fun add(product: Product)

    @Update
    fun update(product: Product)

    @Delete
    fun delete(product: Product)
}