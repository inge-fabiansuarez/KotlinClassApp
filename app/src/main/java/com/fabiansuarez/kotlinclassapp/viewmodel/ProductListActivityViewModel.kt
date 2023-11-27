package com.fabiansuarez.kotlinclassapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.fabiansuarez.kotlinclassapp.model.entity.Product
import com.fabiansuarez.kotlinclassapp.model.repository.ProductRepository
import com.fabiansuarez.kotlinclassapp.view.adapter.ProductAdapter

class ProductListActivityViewModel(application: Application) : AndroidViewModel(application) {

    var products: ArrayList<Product> = arrayListOf()
    var adapter: ProductAdapter = ProductAdapter(products)

    private val productRepository: ProductRepository = ProductRepository(application)

    fun loadProducts() {
        products = productRepository.getAllLocal()
    }

    fun refreshData() {
        adapter.refresh(products)
    }
}