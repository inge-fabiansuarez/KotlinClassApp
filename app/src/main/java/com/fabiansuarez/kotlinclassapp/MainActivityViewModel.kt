package com.fabiansuarez.kotlinclassapp

import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {

    val user: User = User("", "")

    fun login(): Boolean =
        user.name == "Fabian" && user.password == "123"
}