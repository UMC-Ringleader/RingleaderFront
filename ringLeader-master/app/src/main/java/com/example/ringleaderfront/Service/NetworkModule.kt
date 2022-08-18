package com.example.ringleaderfront.Service

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL="http://ec2-15-164-40-248.ap-northeast-2.compute.amazonaws.com:9100"

fun getRetrofit():Retrofit{
    val retrofit=Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    return retrofit
}