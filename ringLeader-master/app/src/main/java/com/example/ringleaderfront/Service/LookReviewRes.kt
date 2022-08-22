package com.example.ringleaderfront.Service

import com.google.gson.annotations.SerializedName

data class LookReviewRes(
    @SerializedName(value="isSuccess") val isSuccess:Boolean,
    @SerializedName(value="code") val code:Int,
    @SerializedName(value="message") var message:String,
    @SerializedName(value="result") val result:List<LookReview>?
)


data class LookReview(
    val userId:Int,
    val nickName:String,
    val userContribution: Int,
    val reviewId:Int,
    val title:String,
    val reviewTitle:String,
    val category: String,
    val hashtag1: String,
    val hashtag2: String,
    val hashtag3: String,
    val contents: String,
    val imgUrls: List<String>,
    val reviewFeedBacks:reviewFeedBack,
    val bookmarked :Boolean
)

data class reviewFeedBack(
    val likeCount:Int,
    val exactInfoCount:Int,
    val sympathyCount:Int,
    val helpfulCount:Int
)
