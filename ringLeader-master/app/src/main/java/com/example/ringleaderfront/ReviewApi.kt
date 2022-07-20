package com.example.ringleaderfront

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface ReviewApi {

    @GET("/app/review/{regionId}")
    suspend fun getReviews(@Path("regionId")regionId:Int): Response<List<ThemeReview>>

    @GET("/app/review/{regionId}?loginUserId={}")
    suspend fun getUpdate(@Path("regionId")Int regionId,@Query("loginUserId") Int loginUserId)

    @GET("/app/review/{regionId}/category?categroy={}")
    suspend fun getUpdate(@Path("regionId")Int regionId,@Query("loginUserId") Int loginUserId)

    @GET("/app/review/profile/{userId}?regionId={}\n")
    suspend fun getUpdate(@Path("regionId")Int regionId,@Query("loginUserId") Int loginUserId)


    @Headers("Content-Type:application/json")
    @POST
    fun addReview(@Body themeReview:ThemeReview): Call<ThemeReview>
}