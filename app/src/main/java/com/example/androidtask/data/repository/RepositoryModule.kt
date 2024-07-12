package com.example.androidtask.data.repository

import com.example.androidtask.data.dataSource.ProductsDataSourceImpl
import com.example.androidtask.dataSource.ProductsDataSource
import com.example.androidtask.repository.ProductsRepository
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