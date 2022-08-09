package com.example.ringleaderfront

import java.io.Serializable

data class Store(
var storeName:String,
var storeReviews:ArrayList<ThemeReview>?
):Serializable
