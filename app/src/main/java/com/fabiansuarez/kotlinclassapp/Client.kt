package com.fabiansuarez.kotlinclassapp

class Client(cart: ArrayList<Product>, name: String, password: String) : User(name, password),
    Shopping {
    override fun login(): Boolean {
        return super.login()

    }

    override fun showInfo() {
        TODO("Not yet implemented")
    }

    override fun buy() {
        TODO("Not yet implemented")
    }

    override fun getBill() {
        TODO("Not yet implemented")
    }

}