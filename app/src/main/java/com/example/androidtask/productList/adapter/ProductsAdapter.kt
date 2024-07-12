package com.example.androidtask.productList.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtask.R
import com.example.androidtask.databinding.ItemProductBinding
import com.example.androidtask.productList.model.Product

class ProductsAdapter(private var products: List<Product?>? = null) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    inner class ViewHolder(private val itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root) {

        fun bind(product: Product?) {

            itemProductBinding.product = product
            itemProductBinding.executePendingBindings()
            if (product?.discountPercentage != null) {
                val newPrice = product?.price?.minus((product?.discountPercentage/100*product?.price))
                itemProductBinding.productPrice.text = itemProductBinding.productPrice.context.getString(R.string.egp, newPrice)
                itemProductBinding.productOldPrice.isVisible = true
                itemProductBinding.productOldPrice.text = itemProductBinding.productPrice.context.getString(R.string.egp, product?.price)
                itemProductBinding.productOldPrice.paintFlags =
                    itemProductBinding.productOldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                itemProductBinding.productPrice.text = itemProductBinding.productPrice.context.getString(R.string.egp, product?.price)

                itemProductBinding.productOldPrice.isVisible = false
            }
            itemProductBinding.ratingValueTv.text = "(${product?.rating})"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = products?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products!![position]
        holder.bind(product)
    }

    fun setProductsList(products: List<Product>?) {
        this.products = products
        notifyDataSetChanged()
    }

}
