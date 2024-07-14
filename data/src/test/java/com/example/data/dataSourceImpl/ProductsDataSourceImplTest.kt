package com.example.data.dataSourceImpl

import com.example.data.api.WebServices
import com.example.data.dataSource.contract.ProductsDataSource
import com.example.data.dataSource.implmentation.ProductsDataSourceImpl
import com.example.data.model.ProductsResponse
import com.example.domain.model.Product
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class ProductsDataSourceImplTest {
    private lateinit var productsDataSource: ProductsDataSource
    private val webServices = mockk<WebServices>()

    @Before
    fun setUp() {
        productsDataSource = ProductsDataSourceImpl(webServices)
    }

    @Test
    fun `when getProducts is called it should get data from api`() = runTest {
        val productsList = listOf(Product(), Product(), Product())

        val productsResponse = ProductsResponse(products = productsList)

        coEvery { webServices.getProducts() } returns productsResponse

        val result = productsDataSource.getProducts()

        assertEquals(productsList, result)
    }
}