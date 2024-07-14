package com.example.androidtask.productList.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidtask.utils.getOrAwaitValueTest
import com.example.domain.model.Product
import com.example.domain.usecases.GetProductsUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class ProductListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var productListViewModel: ProductListViewModel
    private val getProductsUseCase = mockk<GetProductsUseCase>()
    private val testDispatcher = UnconfinedTestDispatcher()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        productListViewModel = ProductListViewModel(getProductsUseCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `verify when getProducts is called it should emit ProductsList`() = runTest {
        val productsList = listOf(Product(), Product(), Product())
        coEvery { getProductsUseCase.invoke() } returns productsList
        productListViewModel.getProducts()
        val result = productListViewModel.productList.getOrAwaitValueTest()
        assertEquals(productsList, result)
    }

    @Test(expected = Exception::class)
    fun `when api call fails it should emit message`() = runTest {
        val expectedMessage = "API call failed"
        coEvery { productListViewModel.getProducts() } throws Exception(expectedMessage)
        productListViewModel.getProducts()
        val result = productListViewModel.message.getOrAwaitValueTest()
        assertEquals(expectedMessage, result)
    }
}
