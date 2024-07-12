package com.example.androidtask.productList.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class ProductsResponse(
	val total: Int? = null,
	val limit: Int? = null,
	val skip: Int? = null,
	val products: List<Product?>? = null
) : Parcelable

