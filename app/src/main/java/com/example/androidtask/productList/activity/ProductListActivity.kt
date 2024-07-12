package com.example.androidtask.productList.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtask.databinding.ActivityProductListBinding
import com.example.androidtask.productList.adapter.ProductsAdapter
import com.example.androidtask.productList.viewmodel.ProductListViewModel
import com.google.android.material.snackbar.Snackbar

class ProductListActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductListViewModel
    private lateinit var binding: ActivityProductListBinding
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        productsAdapter = ProductsAdapter()
        viewModel = ProductListViewModel()
        viewModel.getProducts()
        initViews()
        observeLiveData()

    }
    private fun initViews() {
        binding.productsListRv.adapter = productsAdapter
    }

    private fun observeLiveData() {
        viewModel.productList.observe(this) { products ->
            productsAdapter.setProductsList(products)
        }

        viewModel.message.observe(this) { message ->
            Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG).show()
        }
    }




}