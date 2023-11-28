package com.fabiansuarez.kotlinclassapp.model.repository

import android.content.Context
import com.fabiansuarez.kotlinclassapp.model.entity.Product
import com.fabiansuarez.kotlinclassapp.model.entity.User
import com.fabiansuarez.kotlinclassapp.model.local.StoreAppDB
import com.fabiansuarez.kotlinclassapp.model.local.dao.ProductDAO

class ProductRepository(myContext: Context) {

    private val db: StoreAppDB = StoreAppDB.getInstance(myContext)
    private val productDAO: ProductDAO = db.productDAO()
    var products: ArrayList<Product> = arrayListOf()

    fun getAllLocal(): ArrayList<Product> {
        loadAllLocal()
        return products
    }

    fun loadAllLocal() {
        products = productDAO.getAll() as ArrayList<Product>
        if (products.isEmpty()) {
            loadFakeData()
        }
    }

    private fun loadFakeData() {
        productDAO.apply {
            add(Product(name = "Computador", price = 50000.0))
            add(Product(name = "Teclado", price = 20000.0))
            add(Product(name = "Disco Duro", price = 30000.0))
            add(Product(name = "Monitor", price = 50000.0))
        }
        loadAllLocal()
    }

    fun getByKeyLocal(key: Int): Product {
        loadAllLocal()
        return productDAO.getByKey(key)
    }

    fun addLocal(myProduct: Product) {
        productDAO.add(myProduct)
        loadAllLocal()
    }

    fun updateLocal(myProduct: Product) {
        productDAO.update(myProduct)
        loadAllLocal()
    }

    fun deleteLocal(product: Product) {
        productDAO.delete(product)
        loadAllLocal()
    }

}