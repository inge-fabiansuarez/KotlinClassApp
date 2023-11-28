package com.fabiansuarez.kotlinclassapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.fabiansuarez.kotlinclassapp.model.entity.Product
import com.fabiansuarez.kotlinclassapp.model.repository.ProductRepository

class ProductDetailActivityViewModel(application: Application) : AndroidViewModel(application) {

    var product: Product = Product(name = "", price = 0.0, description = "")
    private val productRepository: ProductRepository = ProductRepository(application)
    fun getProductByKey(myProductKey: Int) {
        product = productRepository.getByKeyLocal(myProductKey)
    }


}