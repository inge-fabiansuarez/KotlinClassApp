package com.fabiansuarez.kotlinclassapp.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.fabiansuarez.kotlinclassapp.model.ProductStatus
import java.io.Serializable

//val solo se crea el getter y NO el setter
//var crea Getter y Setter
@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true)
    var key: Int? = null,
    var name: String,
    var price: Double,
    var description: String = "",
    val status: ProductStatus = ProductStatus.AVAILABLE,
    @ColumnInfo(name = "url_image")
    val urlProduct: String = "https://todotintasysuministros.com/assets/media/hg-1251.jpg"
) : Serializable {

    //este metodo me permite establecer que ejecutar cuando se instancia el objeto
    init {
        println("Producto Instanciado:")
    }

    fun getShortInfo(): String = "$name - $price"
    override fun toString(): String =
        "Product(name='$name', price=$price, description='$description', status=${status.ordinal})"

}