package com.example.ringleaderfront.Service

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PostReviewRes(

    //storeName,images Uri 배열 없음
    @SerializedName(value="userId") var userId:Int,
    @SerializedName(value="title") var title:String,
    @SerializedName(value="category")var category:String,
//    @SerializedName(value="hashtag1")var hashtag1:String,
//    @SerializedName(value="hashtag2")var hashtag2:String,
//    @SerializedName(value="hashtag3")var hashtag3:String,
    @SerializedName(value="hashtags")var hashtags:List<String>,
    @SerializedName(value="contents")var contents:String,
    @SerializedName(value="regionId")var regionId:Int
):Serializable
