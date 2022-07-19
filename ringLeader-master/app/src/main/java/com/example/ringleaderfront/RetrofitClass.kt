package com.example.ringleaderfront

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClass {
    val reviewApi:ReviewApi by lazy{
        Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReviewApi::class.java)

    }
}