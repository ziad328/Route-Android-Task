package com.example.androidtask.productList.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Product
import com.example.domain.usecases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(private val getProductsUseCase: GetProductsUseCase) :
    ViewModel() {

    private val _productsList = MutableLiveData<List<Product>?>()
    val productList: LiveData<List<Product>?> = _productsList

    private val _message = MutableLiveData<String>()
    val message: LiveData<String> = _message

    fun getProducts() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _productsList.postValue(getProductsUseCase.invoke())
            } catch (e: Exception) {
                _message.postValue(e.localizedMessage)
            }

        }
    }

}