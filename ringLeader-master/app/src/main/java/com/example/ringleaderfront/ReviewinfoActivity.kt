package com.example.ringleaderfront

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ringleaderfront.databinding.ActivityMainBinding
import com.example.ringleaderfront.databinding.ActivityReviewinfoBinding

class ReviewinfoActivity : AppCompatActivity() {
    lateinit var binding:ActivityReviewinfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityReviewinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reviewIntent = intent.getSerializableExtra("review_content") as ThemeReview
//
//        binding.reviewShopName.text=reviewIntent.storeName
//        binding.reviewText.text=reviewIntent.text
//        binding.reviewTag1.text=reviewIntent.tags?.get(0)?.tagText
//        binding.reviewTag2.text=reviewIntent.tags?.get(1)?.tagText
//        binding.reviewTag3.text=reviewIntent.tags?.get(2)?.tagText

    }
}