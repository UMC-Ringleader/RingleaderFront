package com.example.ringleaderfront


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RestApiService {
    fun addReview(themeReview: ThemeReview,onResult:(ThemeReview?)->Unit){
        val retrofit=RetrofitClass.buildService(ReviewApi::class.java)
        retrofit.addReview(themeReview).enqueue(
            object:Callback<ThemeReview>{
                override fun onResponse(call: Call<ThemeReview>, response: Response<ThemeReview>) {
                    val addedReview=response.body()
                    onResult(addedReview)
                }

                override fun onFailure(call: Call<ThemeReview>, t: Throwable) {
                    onResult(null)
                }

            }
        )
    }
}