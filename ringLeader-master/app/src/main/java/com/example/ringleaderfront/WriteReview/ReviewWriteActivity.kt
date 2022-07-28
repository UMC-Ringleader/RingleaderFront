package com.example.ringleaderfront.WriteReview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.ringleaderfront.databinding.ActivityReviewWriteBinding


class ReviewWriteActivity : AppCompatActivity() {

    lateinit var binding:ActivityReviewWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewWriteBinding.inflate(layoutInflater)
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
                binding.letterCount.text = reviewText.length.toString() + " / 100,000"
            }

            override fun afterTextChanged(p0: Editable?) {
                reviewText = binding.reviewEditText.text.toString()
                binding.letterCount.text = reviewText.length.toString() + " / 100,000"
            }

        })


        binding.writeBtn.setOnClickListener {
            Toast.makeText(this, "글을 확인하세요", Toast.LENGTH_SHORT).show()

            val titleText = binding.titleEditText.text.toString()
            val tagText = binding.tagEditText.text.toString()
            val review = binding.reviewEditText.text.toString()

            val writeToCheck = Intent(this, ReviewWriteCheckActivity::class.java)

            intent.putExtra("title", titleText)
            intent.putExtra("tag", tagText)
            intent.putExtra("reviewText", review)
            startActivity(writeToCheck)
        }

        imageLoad()

    }


    private fun imageLoad() {

        var Uris = intent.getSerializableExtra("UriArray") as ArrayList<Uri>
        binding.reviewWriteLlIv1.setImageURI(Uris.get(0))
        binding.reviewWriteLlIv2.setImageURI(Uris.get(1))
        binding.reviewWriteLlIv3.setImageURI(Uris.get(2))
    }
}