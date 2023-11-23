package com.fabiansuarez.kotlinclassapp.model

import android.provider.ContactsContract.CommonDataKinds.Email

//open permite que pueda heredar esta clase
//abstract no permite instaciar o crear objetos de esta clase.
open class User(
    var document: String,
    var name: String,
    var email: String,
    var urlPhoto: String = ""
) {

    //open me permite sobreescribir la funcion
    //    open fun login(): Boolean =
    //        name == "fabian@correo.com" && password == "123455"

    // abstract fun showInfo()
}