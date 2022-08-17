package com.example.ringleaderfront

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ringleaderfront.databinding.ActivityReviewReportBinding

class ReviewReportActivity : AppCompatActivity() {

    lateinit var binding: ActivityReviewReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReviewReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}