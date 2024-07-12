package com.example.androidtask.utils


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.androidtask.R
import com.squareup.picasso.Picasso

class BindingAdapters {
    companion object {
        @BindingAdapter("app:urlCircular")
        @JvmStatic
        fun bindImageCircular(imageView: ImageView, url: String?) {
            Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_category_placeholder)
                .transform(TransformCircular())
                .into(imageView)
        }

        @BindingAdapter("app:url")
        @JvmStatic
        fun bindImage(imageView: ImageView, url: String?) {
            Picasso.get()
                .load(url)
                .centerCrop()
                .fit()
                .into(imageView)
        }

    }
}