package com.example.androidtask.dataSource

import com.example.androidtask.productList.model.Product

interface ProductsDataSource {
    suspend fun getProducts(): List<Product>?
}