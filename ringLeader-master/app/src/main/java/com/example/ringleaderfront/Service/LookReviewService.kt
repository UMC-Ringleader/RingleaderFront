package com.example.ringleaderfront.Service

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LookReviewService {

    private lateinit var lookView: LookView

    fun setLookView(lookView: LookView) {
        this.lookView = lookView
    }

    fun getReviews(){
        Log.d("LOOKREVIEWS-RESPONSE","lookReviews() 진입")
        val lookReviewsService = getRetrofit().create(AuthRetrofitInterface::class.java)

        lookReviewsService.lookReviews(15).enqueue(object : Callback<LookReviewRes> {
            override fun onResponse(call: Call<LookReviewRes>, response: Response<LookReviewRes>) {
                Log.d("LOOKREVIEWS-RESPONSE/SUCCESS",response.toString())
                if (response.isSuccessful && response.code() == 200) {
                    val lookReviewsResponse: LookReviewRes = response.body()!!

                    when (val code = lookReviewsResponse.code) {
                        1000 -> {
                            lookView.onGetReviewSuccess(code, lookReviewsResponse.result!!)


                            Log.d("LOOKREVIEWS-RESPONSE/SUCCESS/DATA",lookReviewsResponse.result?.get(0).contents)
                        }

                        else ->{
                            //lookView.onGetSongFailure(code, songResponse.message)
                        }
                    }
                }
            }

            override fun onFailure(call: Call<LookReviewRes>, t: Throwable) {
                //lookView.onGetSongFailure(400, "네트워크 오류가 발생했습니다.")
                Log.d("LOOKREVIEWS-RESPONSE/FAILURE",t.message.toString())
            }
        })
    }

}