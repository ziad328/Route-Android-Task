package com.example.data.dataSource.contract

import com.example.domain.model.Product

interface ProductsDataSource {
    suspend fun getProducts(): List<Product>?
}