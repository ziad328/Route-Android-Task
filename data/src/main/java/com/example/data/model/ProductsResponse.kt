package com.example.data.model

import android.os.Parcelable
import com.example.domain.model.Product
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductsResponse(
	val total: Int? = null,
	val limit: Int? = null,
	val skip: Int? = null,
	val products: List<Product>? = null
) : Parcelable

