package com.fabiansuarez.kotlinclassapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.fabiansuarez.kotlinclassapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tvTitle.text = "ESTE ES MI TITULO PERSONALIZADO"

        var myClient: User = User(name = "Fabian", password = "12345567")

        binding.user = myClient

        binding.btLogIn.setOnClickListener {
            if (binding.user?.name == "Fabian" && binding.user?.password == "12345567") {
                Toast.makeText(
                    this,
                    "Iniciando sesion... ${binding.user?.name}",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(this, "Datos inválidos", Toast.LENGTH_SHORT).show()

            }
        }

    }
}