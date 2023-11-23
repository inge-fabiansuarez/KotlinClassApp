package com.fabiansuarez.kotlinclassapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.fabiansuarez.kotlinclassapp.viewmodel.MainActivityViewModel
import com.fabiansuarez.kotlinclassapp.R
import com.fabiansuarez.kotlinclassapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        binding.viewModel = viewModel

        binding.tvTitle.text = "ESTE ES MI TITULO PERSONALIZADO"
        viewModel.user.email = "fabian@correo.com"
        viewModel.password = "123"

        binding.btLogIn.setOnClickListener {
            if (viewModel.login()) {
                Toast.makeText(
                    this,
                    "Iniciando sesion... ${viewModel.user?.name}",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(applicationContext, ProductListActivity::class.java)
                intent.apply {
                    putExtra("message", "Hola")
                    putExtra("data", viewModel.user.email)
                }
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Datos inválidos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btRegister.setOnClickListener {
            startActivity(Intent(applicationContext, SignUpActivity::class.java))
        }

    }
}