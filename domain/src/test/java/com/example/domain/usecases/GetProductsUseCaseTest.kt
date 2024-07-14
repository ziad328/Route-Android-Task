package com.example.domain.usecases

import com.example.domain.model.Product
import com.example.domain.repository.ProductsRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class GetProductsUseCaseTest {
    private lateinit var getProductsUseCase: GetProductsUseCase
    private val productsRepository = mockk<ProductsRepository>()

    @Before
    fun setUp() {
        getProductsUseCase = GetProductsUseCase(productsRepository)
    }

    @Test
    fun `verify when invoke is called it should call ProductsRepository `() = runTest {
        val productsList = listOf(Product(), Product(), Product())
        coEvery { productsRepository.getProducts() } returns productsList
        getProductsUseCase.invoke()
        coVerify(exactly = 1) { productsRepository.getProducts() }
    }
}