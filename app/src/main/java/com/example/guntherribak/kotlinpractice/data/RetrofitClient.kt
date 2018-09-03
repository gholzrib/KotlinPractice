package com.example.guntherribak.kotlinpractice.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private var INSTANCE: Retrofit? = null

    fun getInstance(): Retrofit {
        if (INSTANCE == null) {
            INSTANCE = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.magicthegathering.io/v1/")
                    .build()
        }
        return INSTANCE as Retrofit
    }

    fun destroy() {
        INSTANCE = null
    }
}