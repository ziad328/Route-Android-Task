package com.example.data.repository

import com.example.data.dataSource.contract.ProductsDataSource
import com.example.domain.model.Product
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(private val productsDataSource: ProductsDataSource) :
    ProductsRepository {
    override suspend fun getProducts(): List<Product>? {
        return productsDataSource.getProducts()
    }
}