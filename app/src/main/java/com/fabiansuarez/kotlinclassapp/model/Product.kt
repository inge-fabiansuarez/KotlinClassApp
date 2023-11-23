package com.fabiansuarez.kotlinclassapp.model

//val solo se crea el getter y NO el setter
//var crea Getter y Setter

data class Product(
    var name: String,
    var price: Double,
    var description: String = "",
    val status: ProductStatus = ProductStatus.AVAILABLE,
    val urlProduct: String = "https://todotintasysuministros.com/assets/media/hg-1251.jpg"
) {

    //este metodo me permite establecer que ejecutar cuando se instancia el objeto
    init {
        println("Producto Instanciado:")
    }

    fun getShortInfo(): String = "$name - $price"
    override fun toString(): String =
        "Product(name='$name', price=$price, description='$description', status=${status.ordinal})"


}