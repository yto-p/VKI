package com.mtuci.vki.main.item

data class GoodItem(
    val id: Int,
    val title: String,
    val description: String,
    val thumbnail: Int,
    val price: Int,
    val stock: Int,
    val rating: Double
)
