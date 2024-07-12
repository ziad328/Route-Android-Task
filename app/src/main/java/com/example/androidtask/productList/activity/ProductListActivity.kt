package com.example.androidtask.productList.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtask.databinding.ActivityProductListBinding
import com.example.androidtask.productList.adapter.ProductsAdapter
import com.example.androidtask.productList.model.Product
import com.example.androidtask.productList.model.products

class ProductListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.productsListRv.adapter = ProductsAdapter(products)
    }

}