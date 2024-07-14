package com.example.data.repository

import com.example.data.dataSource.contract.ProductsDataSource
import com.example.domain.model.Product
import com.example.domain.repository.ProductsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductsRepositoryImplTest {
    private lateinit var productsRepository: ProductsRepository
    private val productsDataSource = mockk<ProductsDataSource>()

    @Before
    fun setUp() {
        productsRepository = ProductsRepositoryImpl(productsDataSource)
    }

    @Test
    fun `verify when getProducts is called it should call ProductsDataSource `() = runTest {
        val productsList = listOf(Product(), Product(), Product())
        coEvery { productsDataSource.getProducts() } returns productsList
        productsRepository.getProducts()
        coVerify(exactly = 1) { productsDataSource.getProducts() }
    }
}