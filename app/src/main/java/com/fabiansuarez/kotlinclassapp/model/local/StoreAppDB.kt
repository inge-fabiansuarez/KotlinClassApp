package com.fabiansuarez.kotlinclassapp.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fabiansuarez.kotlinclassapp.model.local.dao.ProductDAO
import com.fabiansuarez.kotlinclassapp.model.entity.Product

@Database(entities = [Product::class], version = 1, exportSchema = true)
abstract class StoreAppDB : RoomDatabase() {
    abstract fun productDAO(): ProductDAO

    //este companion object me dice o me indica que una clase es estatica ya que en kotlin no existen las llaves estaticas
    companion object {
        private var INSTANCE: StoreAppDB? = null
        fun getInstance(myContext: Context): StoreAppDB {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    myContext,
                    StoreAppDB::class.java, "storeapp.db"
                ).allowMainThreadQueries().build()
            }
            return instance
        }
    }
}