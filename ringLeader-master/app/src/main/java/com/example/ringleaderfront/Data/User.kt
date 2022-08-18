package com.example.ringleaderfront.Data

import android.net.Uri
import com.example.ringleaderfront.Data.ThemeReview


data class User(var userName:String,
                var email:String,
                var pw:Int,
                var levelImage: Uri,
                var profileImage:String,
                var ThemeReviews:Array<ThemeReview>)

