package com.example.androidtask.data.repository

import com.example.androidtask.dataSource.ProductsDataSource
import com.example.androidtask.productList.model.Product
import com.example.androidtask.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productsDataSource: ProductsDataSource) :
    ProductsRepository {
    override suspend fun getProducts(): List<Product>? {
        return productsDataSource.getProducts()
    }
}