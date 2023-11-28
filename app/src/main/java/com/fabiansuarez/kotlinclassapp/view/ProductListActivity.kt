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
import com.fabiansuarez.kotlinclassapp.view.adapter.ProductAdapter

class ProductListActivity : AppCompatActivity() {

    lateinit var binding: ActivityProductListBinding
    lateinit var viewModel: ProductListActivityViewModel
    lateinit var adapter: ProductAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_product_list)

        var message: String? = intent?.getStringExtra("message")
        var email: String? = intent?.getStringExtra("data")



        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list)
        viewModel = ViewModelProvider(this)[ProductListActivityViewModel::class.java]

        adapter = ProductAdapter(viewModel.products)

        binding.adapter = adapter

        binding.btAddProductListProduct.text = "$message $email"

        adapter.onItemClickListener = {
            Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT).show()
            val intent = Intent(applicationContext, ProductDetailActivity::class.java)
            intent.putExtra("product", it)
            startActivity(intent)
        }
        adapter.onItemLongClickListener = {
            Toast.makeText(applicationContext, it.name + "Se elimino", Toast.LENGTH_SHORT).show()
            viewModel.deleteProduct(it)
            adapter.refresh(viewModel.products)
        }

        binding.btAddProductListProduct.setOnClickListener {
            startActivity(Intent(applicationContext, ProductFormActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        viewModel.loadProducts()
        adapter.refresh(viewModel.products)
    }
}