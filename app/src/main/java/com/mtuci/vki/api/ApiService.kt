package com.mtuci.vki.api

import com.mtuci.vki.model.ProductsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // https://dummyjson.com/products?skip=40&limit=20

    @GET("products")
    suspend fun getProductList(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): ProductsResponse
}