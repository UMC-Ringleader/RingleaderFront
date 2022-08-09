package com.example.ringleaderfront.WriteReview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ringleaderfront.MainActivity
import com.example.ringleaderfront.ReviewinfoActivity
import com.example.ringleaderfront.ThemeReview
import com.example.ringleaderfront.databinding.ActivitReviewWriteCheckBinding
import com.example.ringleaderfront.tag
import java.time.LocalDate

class ReviewWriteCheckActivity : AppCompatActivity() {

    lateinit var binding: ActivitReviewWriteCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitReviewWriteCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleText = intent.getStringExtra("titleTxt")
        val tagText = intent.getStringExtra("tagTxt")
        val reviewText = intent.getStringExtra("reviewTxt")
        val query: String? = intent.getStringExtra("query")
        val todayDate = intent.getStringExtra("date")

        val tagData = tagText!!.split(" ")

        binding.titleCheckText.text = titleText
        binding.reviewTag1.text = "#" + tagData.get(0)
        binding.reviewTag2.text = "#" + tagData.get(1)
        binding.reviewTag3.text = "#" + tagData.get(2)
        binding.reviewCheckText.text = reviewText
        binding.storeNameCheck.text = "\"" + query + "\""



        var UriArray = intent.getSerializableExtra("UriArray") as ArrayList<Uri>
        binding.reviewWriteLlIv1.setImageURI(UriArray.get(0))
        binding.reviewWriteLlIv2.setImageURI(UriArray.get(1))
        binding.reviewWriteLlIv3.setImageURI(UriArray.get(2))


        var themeReview4 =
            ThemeReview(titleText, query, "catagory5", null, tagData, todayDate, reviewText)


        binding.postBtn.setOnClickListener {
            Toast.makeText(this, "작성 완료", Toast.LENGTH_SHORT).show()

            val postCheck = Intent(this, ReviewinfoActivity::class.java)
            postCheck.putExtra("review_content", themeReview4)
            startActivity(postCheck)
        }

        binding.reviewSelectSearchArrowIv.setOnClickListener{
            val backIntent = Intent(this, ReviewWriteActivity::class.java)
            startActivity(backIntent)
        }
    }
}