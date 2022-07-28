package com.example.ringleaderfront.WriteReview

import android.net.Uri
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

        binding.titleCheckText.text = intent.getStringExtra("titleTxt")
        binding.tagCheckText.text = intent.getStringExtra("tagTxt")
        binding.reviewCheckText.text = intent.getStringExtra("reviewTxt")

        var Uris = intent.getSerializableExtra("UriArray") as ArrayList<Uri>
        binding.reviewWriteLlIv1.setImageURI(Uris.get(0))
        binding.reviewWriteLlIv2.setImageURI(Uris.get(1))
        binding.reviewWriteLlIv3.setImageURI(Uris.get(2))


        binding.postBtn.setOnClickListener {
            Toast.makeText(this, "작성 완료", Toast.LENGTH_SHORT).show()
        }
    }
}