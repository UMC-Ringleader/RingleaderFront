package com.example.ringleaderfront.WriteReview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ringleaderfront.ReviewinfoActivity
import com.example.ringleaderfront.ThemeReview
import com.example.ringleaderfront.databinding.ActivitReviewWriteCheckBinding
import com.example.ringleaderfront.tag

class ReviewWriteCheckActivity : AppCompatActivity() {

    lateinit var binding: ActivitReviewWriteCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitReviewWriteCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleText = intent.getStringExtra("titleTxt")
        val tagText = intent.getStringExtra("tagTxt")
        val reviewText = intent.getStringExtra("reviewTxt")
        val query = intent.getStringExtra("query")

        binding.titleCheckText.text = titleText
        binding.tagCheckText.text = tagText
        binding.reviewCheckText.text = reviewText
        binding.storeNameCheck.text = "\"" + query + "\""

        var Uris = intent.getSerializableExtra("UriArray") as ArrayList<Uri>
        binding.reviewWriteLlIv1.setImageURI(Uris.get(0))
        binding.reviewWriteLlIv2.setImageURI(Uris.get(1))
        binding.reviewWriteLlIv3.setImageURI(Uris.get(2))


        var themeReview4 = ThemeReview(titleText, query, "catagory5", null, ArrayList(), reviewText)
        themeReview4.tags?.add(tag("tag1_1"))
        themeReview4.tags?.add(tag("tag1_2"))
        themeReview4.tags?.add(tag("tag1_3"))

        binding.postBtn.setOnClickListener {
            Toast.makeText(this, "작성 완료", Toast.LENGTH_SHORT).show()

            val postCheck = Intent(this, ReviewinfoActivity::class.java)
            //postCheck.putExtra("titleTxt", "titleTxt")
            //postCheck.putExtra("tagTxt", "tagTxt")
            //postCheck.putExtra("reviewTxt", "reviewTxt")
            //postCheck.putExtra("UriArray", "UriArray")
            //postCheck.putExtra("query", "query")
            postCheck.putExtra("review_content", themeReview4)
            startActivity(postCheck)
        }
    }
}