package com.fabiansuarez.kotlinclassapp

import androidx.lifecycle.ViewModel

class SignUpActivityViewModel : ViewModel() {
    var user: User = User("", "", "", "")
    var password: String = ""

    fun signUp(): User {
        return user
    }
}