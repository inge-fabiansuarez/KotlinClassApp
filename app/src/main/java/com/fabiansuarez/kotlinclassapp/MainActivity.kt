package com.fabiansuarez.kotlinclassapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
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

        binding.btLogIn.setOnClickListener {
            if (viewModel.login()) {
                Toast.makeText(
                    this,
                    "Iniciando sesion... ${viewModel.user?.name}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this, "Datos inválidos", Toast.LENGTH_SHORT).show()

            }
        }

    }
}