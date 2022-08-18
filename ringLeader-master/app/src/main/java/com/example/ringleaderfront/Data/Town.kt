package com.example.ringleaderfront.Data

import com.example.ringleaderfront.Data.ThemeReview
import java.io.Serializable


data class Town(
    val name:String?,
    val themeReviews: ArrayList<ThemeReview>?=null):Serializable
