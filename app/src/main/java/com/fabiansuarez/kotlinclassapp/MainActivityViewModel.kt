package com.fabiansuarez.kotlinclassapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val user: User = User("", "", "", "")
    var password: String = ""
    fun login(): Boolean = user.email == "fabian@correo.com" && password == "123"
}