package com.example.androidtask.data.dataSource

import com.example.androidtask.data.api.WebServices
import com.example.androidtask.dataSource.ProductsDataSource
import com.example.androidtask.productList.model.Product
import javax.inject.Inject

class ProductsDataSourceImpl @Inject constructor(private val webServices: WebServices) :
    ProductsDataSource {
    override suspend fun getProducts(): List<Product>? {
        val response = webServices.getProducts()
        return response.products
    }
}