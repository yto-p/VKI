package com.mtuci.vki.model

import androidx.paging.PagingData

//"id":1,
// "title":"iPhone 9",
// "description":"An apple mobile which is nothing like apple",
// "price":549,
// "rating":4.69,
// "stock":94,
// "brand":"Apple",
// "category":"smartphones",
// "thumbnail":"https://cdn.dummyjson.com/product-images/1/thumbnail.jpg",
data class ProductDTO(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val thumbnail: String
)

data class ProductsResponse(
    val products: List<ProductDTO>
)
