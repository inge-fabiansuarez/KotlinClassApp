package com.fabiansuarez.storeappclase2024

import android.provider.ContactsContract.CommonDataKinds.Email

//open permite que pueda heredar esta clase
//abstract no permite instaciar o crear objetos de esta clase.
abstract class User(val name: String, val password: String) {

    //open me permite sobreescribir la funcion
    open fun login(): Boolean =
        name == "fabian@correo.com" && password == "123455"

    abstract fun showInfo()
}