package com.example.ringleaderfront.Service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthRetrofitInterface {
    @POST("/app/review/")
    fun reviewCheck(@Body review: PostReviewRes): Call<PostUserRes>

    @GET("/app/review/{regionId}")
    fun lookReviews(@Path("regionId") regionId :Int): Call<LookReviewRes>


}