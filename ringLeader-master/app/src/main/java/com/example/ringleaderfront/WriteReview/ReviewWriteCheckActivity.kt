package com.example.ringleaderfront.WriteReview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ringleaderfront.databinding.ActivitReviewWriteCheckBinding

class ReviewWriteCheckActivity : AppCompatActivity() {

    lateinit var binding: ActivitReviewWriteCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitReviewWriteCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.titleCheckText.text = intent.getStringExtra("title")
        binding.tagCheckText.text = intent.getStringExtra("tag")
        binding.reviewCheckText.text = intent.getStringExtra("reviewText")


        binding.postBtn.setOnClickListener {
            Toast.makeText(this, "작성 완료", Toast.LENGTH_SHORT).show()
        }
    }
}