package com.example.ringleaderfront

import java.io.Serializable


data class Town(
    val name:String?,
    val themeReviews: ArrayList<ThemeReview>?=null):Serializable
