package com.example.ringleaderfront

import android.net.Uri


data class User(var userName:String,
                var email:String,
                var pw:Int,
                var levelImage: Uri,
                var profileImage:String,
                var ThemeReviews:Array<ThemeReview>)

