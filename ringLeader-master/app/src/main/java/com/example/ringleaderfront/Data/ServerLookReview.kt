package com.example.ringleaderfront.Data

data class ServerLookReview(

    val userName: String?,
    val userContribution: Int,
    val title:String,
    val category: String,
    val hashtag1: String,
    val hashtag2: String,
    val hashtag3: String,
    val contents: String,
    val imgUrls: List<String>?,

    )
