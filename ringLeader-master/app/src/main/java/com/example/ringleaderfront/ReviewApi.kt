package com.example.ringleaderfront

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ReviewApi {

    @GET("/app/review")
    suspend fun getReviews(@Query("regionId")regionId:Int): Response<List<ThemeReview>>

//    @POST
//    fun createReview(@Body ThemeReview:ThemeReview):Response<Create>
}