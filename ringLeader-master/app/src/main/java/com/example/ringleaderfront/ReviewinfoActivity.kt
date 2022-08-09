package com.example.ringleaderfront

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ringleaderfront.databinding.ActivityMainBinding
import com.example.ringleaderfront.databinding.ActivityReviewinfoBinding

class ReviewinfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityReviewinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.reviewProfileImg.clipToOutline = true
        binding.badgeImg.clipToOutline = true

        val reviewIntent = intent.getSerializableExtra("review_content") as ThemeReview


        binding.titleText.text = reviewIntent.title
        binding.reviewShopName.text = reviewIntent.storeName
        binding.reviewText.text = reviewIntent.text
        binding.todayDate.text = reviewIntent.date
        binding.reviewTag1.text = "#" + reviewIntent.tags?.get(0)
        binding.reviewTag2.text = "#" + reviewIntent.tags?.get(1)
        binding.reviewTag3.text = "#" + reviewIntent.tags?.get(2)


        //사진 전달......
//        var imgUri1 = reviewIntent.imgUri?.get(0)
//        var imgUri2 = reviewIntent.imgUri?.get(1)
//        var imgUri3 = reviewIntent.imgUri?.get(2)
//        binding.reviewLlIv1.setImageURI(imgUri1)
//        binding.reviewLlIv2.setImageURI(imgUri2)
//        binding.reviewLlIv3.setImageURI(imgUri3)



    }

    override fun onBackPressed() {
        Toast.makeText(this, "뒤로 가기", Toast.LENGTH_SHORT).show()

        val backIntent = Intent(this, MainActivity::class.java)
        startActivity(backIntent)


//
//        binding.reviewShopName.text=reviewIntent.storeName
//        binding.reviewText.text=reviewIntent.text
//        binding.reviewTag1.text=reviewIntent.tags?.get(0)?.tagText
//        binding.reviewTag2.text=reviewIntent.tags?.get(1)?.tagText
//        binding.reviewTag3.text=reviewIntent.tags?.get(2)?.tagText


    }
}