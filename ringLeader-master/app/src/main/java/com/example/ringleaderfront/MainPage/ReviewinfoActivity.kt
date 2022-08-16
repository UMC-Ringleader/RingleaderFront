package com.example.ringleaderfront.MainPage

import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ringleaderfront.ThemeReview
import com.example.ringleaderfront.databinding.ActivityReviewinfoBinding
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.ringleaderfront.R

import com.example.ringleaderfront.databinding.ActivityMainBinding
import com.example.ringleaderfront.tag
import kotlinx.android.synthetic.main.review_card.view.*
import java.io.Serializable

class ReviewinfoActivity : AppCompatActivity(), Serializable {

    lateinit var binding: ActivityReviewinfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewinfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reviewIntent = intent.getSerializableExtra("review_content") as ThemeReview
//
        binding.reviewShopName.text = reviewIntent.storeName
        binding.reviewText.text = reviewIntent.review_text

        //리뷰제목
        binding.titleText.text=reviewIntent.title


        //날짜
        binding.todayDate.text=reviewIntent.date

        //태그
        binding.activityReviewinfoTagsLl.removeAllViews()

        reviewIntent.tags?.let{
            for(tag in it){
                val layoutParams=LinearLayout.LayoutParams(  LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                val tagTextView = TextView(this@ReviewinfoActivity)
                tagTextView.text=tag.tagText
                binding.activityReviewinfoTagsLl.addView(tagTextView)
               tagTextView.setTextColor(ContextCompat.getColor(this, R.color.main_color))

            }
        }



        //이미지
        binding.activityReviewinfoIvLl.removeAllViews()
        if (reviewIntent.images.size != 0) {
            for (image in reviewIntent.images) {
                val showImage = ImageView(this@ReviewinfoActivity)
                val imageLayoutParams = LinearLayout.LayoutParams(
                    130,
                    130,
                )
                showImage.layoutParams = imageLayoutParams
                Glide.with(this).load(image).into(showImage)
                binding.activityReviewinfoIvLl.addView(showImage)
            }

        }
    }


//        binding.reviewTag1.text=reviewIntent.tags?.get(0)?.tagText
//        binding.reviewTag2.text=reviewIntent.tags?.get(1)?.tagText
//        binding.reviewTag3.text=reviewIntent.tags?.get(2)?.tagText

}