package com.example.ringleaderfront.WriteReview

import android.content.Intent
import android.net.Uri
import android.os.Bundle

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.ringleaderfront.Service.PostReviewRes
import com.example.ringleaderfront.Data.ThemeReview
import com.example.ringleaderfront.databinding.ActivitReviewWriteCheckBinding
import com.example.ringleaderfront.Data.tag
import com.example.ringleaderfront.Service.AuthRetrofitInterface
import com.example.ringleaderfront.Service.PostUserRes
import com.example.ringleaderfront.Service.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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


//        var storeName:String,
//        var catagory:String,
//        var user: User?,
//        var title:String,
//        var tags:ArrayList<tag>?,
//        var images:ArrayList<Uri>,
//        var review_text:String
        var tags1=ArrayList<tag>()
        tags1.add(tag(tagData.get(0)))
        tags1.add(tag(tagData.get(1)))
        tags1.add(tag(tagData.get(2)))

        var images1=ArrayList<Uri>()
        images1.add(UriArray.get(0))
        images1.add(UriArray.get(1))
        images1.add(UriArray.get(2))

        var themeReview4 =
            ThemeReview( query.toString(),
                "catagory5",
                null,
                todayDate,
                titleText.toString(),
                tags1,
                images1,
                reviewText.toString())



        binding.reviewSelectSearchArrowIv.setOnClickListener{
            val backIntent = Intent(this, ReviewWriteActivity::class.java)
            startActivity(backIntent)
        }

        //확인 누르면 post 하는 버튼
        binding.postBtn.setOnClickListener {
            reviewCheck()
        }
    }

    private fun reviewCheck() {
        val authService= getRetrofit().create(AuthRetrofitInterface::class.java)
        authService.reviewCheck(getPostReviewRes()).enqueue(object : Callback<PostUserRes>{
            override fun onResponse(call: Call<PostUserRes>, response: Response<PostUserRes>) {
                Log.d("REVIEWCHECK/SUCCESS",response.toString())
                val resp:PostUserRes=response.body()!!
                when(resp.code){
                    1000->finish()
                    else->{

                    }
                }
            }

            override fun onFailure(call: Call<PostUserRes>, t: Throwable) {
                Log.d("REVIEWCHECK/FAILURE",t.message.toString())
            }

        })
        Log.d("REVIEWCHECK","HELLO")
    }

    private fun getPostReviewRes(): PostReviewRes {
        var userId =10
        var title ="Test Title 1"
        var category ="카페"
//        var hashtag1 = "치즈케이크"
//        var hashtag2 ="24시"
//        var hashtag3 = ""

        var hashtags=ArrayList<String>()
        hashtags.add("카페")
        hashtags.add("치즈케이크")
        hashtags.add("24시")


        var contents = "치즈케이크가 맛있는 24시간 카페"
        var regionId=  15

        return PostReviewRes(userId,title,category,hashtags,contents,regionId)
    }
}