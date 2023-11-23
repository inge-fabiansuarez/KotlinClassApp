package com.fabiansuarez.kotlinclassapp.viewmodel

import androidx.lifecycle.ViewModel
import com.fabiansuarez.kotlinclassapp.model.User

class MainActivityViewModel : ViewModel() {

    val user: User = User("", "", "", "")
    var password: String = ""
    fun login(): Boolean = user.email == "fabian@correo.com" && password == "123"
}