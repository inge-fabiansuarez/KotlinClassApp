package com.fabiansuarez.kotlinclassapp.viewmodel

import androidx.lifecycle.ViewModel
import com.fabiansuarez.kotlinclassapp.model.entity.User

class SignUpActivityViewModel : ViewModel() {
    var user: User = User("", "", "", "")
    var password: String = ""

    fun signUp(): User {
        return user
    }
}