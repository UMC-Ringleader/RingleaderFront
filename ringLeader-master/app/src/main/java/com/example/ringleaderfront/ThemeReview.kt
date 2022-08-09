package com.example.ringleaderfront

import android.net.Uri
import java.io.Serializable

data class ThemeReview(
    var title: String?,
    var storeName:String?,
    var catagory:String,
    var user: User?,
    var tags:List<String>?,
    var date:String?,
//    var imgUri: ArrayList<Uri>?,
    var text:String?
): Serializable
