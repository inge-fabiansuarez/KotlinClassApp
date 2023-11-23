package com.fabiansuarez.kotlinclassapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fabiansuarez.kotlinclassapp.databinding.ActivityProductListBinding
import com.fabiansuarez.kotlinclassapp.databinding.ProductItemBinding

class ProductListActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductListBinding
    lateinit var viewModel: ProductListActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_product_list)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel = ViewModelProvider(this)[ProductListActivityViewModel::class.java]
        binding.viewModel = viewModel

        viewModel.loadProducts()
        viewModel.refreshData()

    }
}