package com.example.androidtask.data.api

import com.example.androidtask.productList.model.ProductsResponse
import retrofit2.http.GET

interface WebServices {
    @GET("/products")
    suspend fun getProducts(): ProductsResponse
}