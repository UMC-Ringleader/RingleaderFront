package com.example.umcproject

import android.nfc.Tag

data class ThemeReview(
    var catagory:String,
    var user:User,
    var tags:Array<tag>,
    var image:String,
    var text:String

)
