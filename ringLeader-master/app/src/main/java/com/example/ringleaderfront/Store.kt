package com.example.ringleaderfront

import com.example.ringleaderfront.Data.ThemeReview
import java.io.Serializable

data class Store(
var storeName:String,
var storeReviews:ArrayList<ThemeReview>?
):Serializable
