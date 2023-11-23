package com.fabiansuarez.kotlinclassapp.viewmodel

import androidx.lifecycle.ViewModel
import com.fabiansuarez.kotlinclassapp.model.Product
import com.fabiansuarez.kotlinclassapp.view.adapter.ProductAdapter

class ProductListActivityViewModel : ViewModel() {

    val products: ArrayList<Product> = arrayListOf()
    var adapter: ProductAdapter = ProductAdapter(products)

    fun loadProducts() {
        products.apply {
            clear()
            add(Product(name = "Computador", price = 50000.0))
            add(Product(name = "Teclado", price = 20000.0))
            add(Product(name = "Disco Duro", price = 30000.0))
            add(Product(name = "Monitor", price = 50000.0))
        }
    }

    fun refreshData() {
        adapter.refresh(products)
    }
}