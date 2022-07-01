package com.example.umcproject

data class User(var userName:String,
                var email:String,
                var pw:Int,
                var scores:Array<Int>,
                var image:String,
                var ThemeReviews:Array<ThemeReview>)

