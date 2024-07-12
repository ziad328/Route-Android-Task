package com.example.androidtask.repository

import com.example.androidtask.productList.model.Product

interface ProductsRepository {
    suspend fun getProducts(): List<Product>?
}