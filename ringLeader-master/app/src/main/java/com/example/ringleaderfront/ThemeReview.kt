package com.example.ringleaderfront

import java.io.Serializable

data class ThemeReview(
    var storeName:String,
    var catagory:String,
    var user: User?,
    var tags:ArrayList<tag>?,
    var image:String,
    var text:String

): Serializable
