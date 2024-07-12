package com.example.androidtask.productList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtask.productList.model.Product
import com.example.androidtask.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val productsRepository: ProductsRepository) :
    ViewModel() {

    private val _productsList = MutableLiveData<List<Product>?>()
    val productList: LiveData<List<Product>?> = _productsList

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun getProducts() {
        viewModelScope.launch {
            try {

                _productsList.value = productsRepository.getProducts()
            } catch (e: Exception) {
                _message.value = e.localizedMessage
            }

        }
    }

}