package com.example.androidtask.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManger {
    private var retrofit: Retrofit? = null

    private fun getInstance(): Retrofit {
        if (retrofit == null) {
            return Retrofit.Builder()
                .baseUrl("https://dummyjson.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        } else {
            return retrofit!!
        }
    }

    fun getApis(): WebServices {
        return getInstance().create(WebServices::class.java)
    }


}