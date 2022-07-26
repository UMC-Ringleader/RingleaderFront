package com.example.ringleaderfront.WriteReview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.ringleaderfront.databinding.ActivityReviewWriteBinding


class ReviewWriteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var reviewText: String = ""
        binding.writeBtn.isEnabled = false

        binding.reviewEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.letterCount.text = "0 / 100,000"
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                reviewText = binding.reviewEditText.text.toString()
                binding.writeBtn.isEnabled = reviewText.isNotEmpty()
                binding.letterCount.text = reviewText.length.toString()+ " / 100,000"
            }

            override fun afterTextChanged(p0: Editable?) {
                reviewText = binding.reviewEditText.text.toString()
                binding.letterCount.text = reviewText.length.toString()+ " / 100,000"
            }

        })

        binding.writeBtn.setOnClickListener {
            Toast.makeText(this, reviewText, Toast.LENGTH_SHORT).show()
        }

    }
}