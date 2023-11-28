package com.fabiansuarez.kotlinclassapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.fabiansuarez.kotlinclassapp.R
import com.fabiansuarez.kotlinclassapp.databinding.ActivityProductDetailBinding
import com.fabiansuarez.kotlinclassapp.model.entity.Product
import com.fabiansuarez.kotlinclassapp.viewmodel.ProductDetailActivityViewModel

class ProductDetailActivity : AppCompatActivity() {

    lateinit var viewModel: ProductDetailActivityViewModel
    lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val myProduct: Product = intent.getSerializableExtra("product") as Product
        //setContentView(R.layout.activity_product_detail)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail)
        viewModel = ViewModelProvider(this).get(ProductDetailActivityViewModel::class.java)
        viewModel.product = myProduct
        binding.viewModel = viewModel

        binding.btEditarDetail.setOnClickListener {
            var intent: Intent = Intent(applicationContext, ProductFormActivity::class.java)
            intent.putExtra("product", myProduct)
            startActivity(intent)
        }

    }
}