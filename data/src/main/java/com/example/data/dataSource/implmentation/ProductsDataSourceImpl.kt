package com.example.data.dataSource.implmentation

import com.example.data.api.WebServices
import com.example.data.dataSource.contract.ProductsDataSource
import com.example.domain.model.Product
import javax.inject.Inject

class ProductsDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    ProductsDataSource {
    override suspend fun getProducts(): List<Product>? {
        val response = webServices.getProducts()
        return response.products
    }
}