package com.example.ringleaderfront.Data

import com.example.ringleaderfront.Service.reviewFeedBack

data class ServerLookReview(
    val userId:Int,
    val nickName: String?,
    val userContribution: Int,
    val title:String,
    val reviewTitle:String,
    val category: String,
    val hashtag1: String,
    val hashtag2: String,
    val hashtag3: String,
    val contents: String,
    val imgUrls: List<String>?,
    val reviewFeedBacks:reviewFeedBack,
    val bookmarked:Boolean

    )
