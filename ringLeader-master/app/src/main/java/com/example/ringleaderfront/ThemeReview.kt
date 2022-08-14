package com.example.ringleaderfront

import android.net.Uri
import android.os.Parcelable
import java.io.Serializable

data class ThemeReview(

    var storeName:String,
    var catagory:String,
    var user: User?,
    var title:String,
    var tags:ArrayList<tag>?,
    var images:ArrayList<Uri>,
    var review_text:String


): Serializable
