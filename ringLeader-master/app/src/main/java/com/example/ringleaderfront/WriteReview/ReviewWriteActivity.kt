package com.example.ringleaderfront.WriteReview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
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
                binding.letterCount.text = "0 / 10,000"
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                reviewText = binding.reviewEditText.text.toString()

                binding.letterCount.text = reviewText.length.toString() + " / 10,000"
            }

            override fun afterTextChanged(p0: Editable?) {
                reviewText = binding.reviewEditText.text.toString()
                binding.letterCount.text = reviewText.length.toString() + " / 10,000"
                binding.writeBtn.isEnabled = reviewText.isNotEmpty()
            }

        })

        var Uris = intent.getSerializableExtra("UriArray") as ArrayList<Uri>
        binding.reviewWriteLlIv1.setImageURI(Uris.get(0))
        binding.reviewWriteLlIv2.setImageURI(Uris.get(1))
        binding.reviewWriteLlIv3.setImageURI(Uris.get(2))

        binding.writeBtn.setOnClickListener {
            Toast.makeText(this, "글을 확인하세요", Toast.LENGTH_SHORT).show()

            val titleText = binding.titleEditText.text.toString()
            val tagText = binding.tagEditText.text.toString()
            val reviewText = binding.reviewEditText.text.toString()
            var query = intent.getStringExtra("query")

            val writeToCheck = Intent(this, ReviewWriteCheckActivity::class.java)
            writeToCheck.putExtra("titleTxt", titleText)
            writeToCheck.putExtra("tagTxt", tagText)
            writeToCheck.putExtra("reviewTxt", reviewText)
            writeToCheck.putExtra("UriArray", Uris)
            writeToCheck.putExtra("query", query)
            startActivity(writeToCheck)
        }
    }
}