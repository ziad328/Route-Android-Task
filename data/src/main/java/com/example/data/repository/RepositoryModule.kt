package com.example.data.repository

import com.example.data.dataSource.contract.ProductsDataSource
import com.example.data.dataSource.implmentation.ProductsDataSourceImpl
import com.example.domain.repository.ProductsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun provideProductsDataSource(dataSourceImpl: ProductsDataSourceImpl): ProductsDataSource

    @Binds
    fun provideProductsRepository(productsRepositoryImpl: ProductsRepositoryImpl): ProductsRepository
}