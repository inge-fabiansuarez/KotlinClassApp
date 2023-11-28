package com.fabiansuarez.kotlinclassapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fabiansuarez.kotlinclassapp.model.entity.Product
import com.fabiansuarez.kotlinclassapp.model.repository.ProductRepository

class ProductFormActivityViewModel(application: Application) :
    AndroidViewModel(application = application) {
    private val productRepository: ProductRepository = ProductRepository(application)

    var product: Product = Product(name = "", price = 0.0)

    fun add() {
        productRepository.addLocal(product)
    }

    fun edit() {
        productRepository.updateLocal(product)
    }
}