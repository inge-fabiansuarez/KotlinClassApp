package com.fabiansuarez.kotlinclassapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.fabiansuarez.kotlinclassapp.viewmodel.ProductListActivityViewModel
import com.fabiansuarez.kotlinclassapp.R
import com.fabiansuarez.kotlinclassapp.databinding.ActivityProductListBinding

class ProductListActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductListBinding
    lateinit var viewModel: ProductListActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_product_list)

        var message: String? = intent?.getStringExtra("message")
        var email: String? = intent?.getStringExtra("data")



        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel = ViewModelProvider(this)[ProductListActivityViewModel::class.java]
        binding.viewModel = viewModel

        viewModel.loadProducts()
        viewModel.refreshData()

        binding.btAddProductListProduct.text = "$message $email"

        viewModel.adapter.onItemClickListener = {
            Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, ProductDetailActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }

    }
}