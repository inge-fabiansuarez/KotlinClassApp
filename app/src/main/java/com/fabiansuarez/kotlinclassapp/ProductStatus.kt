package com.fabiansuarez.storeappclase2024

/*enum class ProductStatus {
    AVAILABLE, SENT, SOLD
}*/

enum class ProductStatus(val value: Int) {
    AVAILABLE(1), SENT(2), SOLD(3);

    fun description(): String {
        return when (this) {
            AVAILABLE -> "Producto disponible"
            SENT -> "Producto enviado"
            SOLD -> "Producto vendido"
        }
    }
}