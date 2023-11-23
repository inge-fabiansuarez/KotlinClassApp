package com.fabiansuarez.kotlinclassapp.viewmodel

import androidx.lifecycle.ViewModel
import com.fabiansuarez.kotlinclassapp.model.Product

class ProductDetailActivityViewModel : ViewModel() {

    var product: Product = Product("", 0.0, "")

}