package com.fabiansuarez.kotlinclassapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fabiansuarez.kotlinclassapp.R
import com.fabiansuarez.kotlinclassapp.databinding.ActivityProductFormBinding
import com.fabiansuarez.kotlinclassapp.model.entity.Product
import com.fabiansuarez.kotlinclassapp.viewmodel.ProductFormActivityViewModel

class ProductFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductFormBinding
    private lateinit var viewModel: ProductFormActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_product_form)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_form)

        viewModel = ViewModelProvider(this).get(ProductFormActivityViewModel::class.java)
        binding.viewModel = viewModel

        binding.btSaveProductForm.setOnClickListener {
            viewModel.add()
            finish()
        }
    }
}