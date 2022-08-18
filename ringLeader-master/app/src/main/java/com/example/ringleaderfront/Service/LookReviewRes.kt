package com.example.ringleaderfront.Service

import com.google.gson.annotations.SerializedName

data class LookReviewRes(
    @SerializedName(value="isSuccess") val isSuccess:Boolean,
    @SerializedName(value="code") val code:Int,
    @SerializedName(value="message") var message:String,
//    @SerializedName(value="result") val result:LookReviewResult?
    @SerializedName(value="result") val result:List<LookReview>?
)
//
//data class LookReviewResult(
//     val reviews: List<LookReview>
//)

data class LookReview(
    val userName: Int,
    val userContribution: Int,
    val category: String,
    val hashtag1: String,
    val hashtag2: String,
    val hashtag3: String,
    val contents: String,
    val imgUrls: List<String>,
)

