package com.example.androidtask.productList.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Product(
    val images: List<String?>? = null,
    val thumbnail: String? = null,
    val minimumOrderQuantity: Int? = null,
    val rating: Float? = null,
    val returnPolicy: String? = null,
    val description: String? = null,
    val weight: Int? = null,
    val warrantyInformation: String? = null,
    val title: String? = null,
    val tags: List<String?>? = null,
    val discountPercentage: Float? = null,
    val price: Float? = null,
    val shippingInformation: String? = null,
    val id: Int? = null,
    val availabilityStatus: String? = null,
    val category: String? = null,
    val stock: Int? = null,
    val sku: String? = null,
    val brand: String? = null
) : Parcelable

val products = listOf(
    Product(
        thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png",
        title = "Essence Mascara Lash Princess",
        rating = 4.5F,
        price = 100F,
        discountPercentage = 20F
    ),
    Product(
        thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png",
        title = "Essence Mascara Lash Princess",
        rating = 4.5F,
        price = 100F,
        discountPercentage = 20F
    ),
    Product(
        thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png",
        title = "Essence Mascara Lash Princess",
        rating = 4.5F,
        price = 100F,
        discountPercentage = 20F
    ),
    Product(
        thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png",
        title = "Essence Mascara Lash Princess",
        rating = 4.5F,
        price = 100F,
        discountPercentage = 20F
    ),
    Product(
        thumbnail = "https://cdn.dummyjson.com/products/images/beauty/Essence%20Mascara%20Lash%20Princess/thumbnail.png",
        title = "Essence Mascara Lash Princess",
        rating = 4.5F,
        price = 100F,
        discountPercentage = 20F
    )
)