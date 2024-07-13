package com.example.domain.usecases

import com.example.domain.model.Product
import com.example.domain.repository.ProductsRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productsRepository: ProductsRepository
) {
    suspend fun invoke(): List<Product>? {
        return productsRepository.getProducts()
    }
}