package com.fabiansuarez.kotlinclassapp.viewmodel

import androidx.lifecycle.ViewModel
import com.fabiansuarez.kotlinclassapp.model.entity.Product

class ProductDetailActivityViewModel : ViewModel() {

    var product: Product = Product(name = "", price = 0.0, description = "")

}