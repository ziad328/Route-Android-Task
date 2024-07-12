package com.example.androidtask.productList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtask.api.ApiManger
import com.example.androidtask.productList.model.Product
import kotlinx.coroutines.launch

class ProductListViewModel : ViewModel() {

    private val _productsList = MutableLiveData<List<Product>?>()
    val productList: LiveData<List<Product>?> = _productsList

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun getProducts() {
        viewModelScope.launch {
            try {
                _productsList.value = ApiManger.getApis().getProducts().products
            } catch (e: Exception) {
                _message.value = e.localizedMessage
            }

        }
    }

}