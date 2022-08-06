package com.example.ringleaderfront

import android.content.ContentUris
import android.net.Uri
import java.io.Serializable

data class ThemeReview(
    var title: String?,
    var storeName: String?,
    var catagory:String,
    var user: User?,
    var tags:ArrayList<tag>?,
    //var imgUri: Uri?,
    var text: String?


): Serializable
