package com.example.ringleaderfront.Service

import com.google.gson.annotations.SerializedName

data class PostUserRes(
    @SerializedName(value="isSuccess") val isSuccess:Boolean,
    @SerializedName(value="code") val code:Int,
    @SerializedName(value="message") var message:String,
    @SerializedName(value="result") val result:Result?

    )

data class Result(
    val reviewId:Int,
    val title:String
)
