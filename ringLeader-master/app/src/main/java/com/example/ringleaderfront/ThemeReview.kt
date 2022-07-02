package com.example.ringleaderfront

data class ThemeReview(
    var catagory:String,
    var user: User,
    var tags:Array<tag>,
    var image:String,
    var text:String

)
