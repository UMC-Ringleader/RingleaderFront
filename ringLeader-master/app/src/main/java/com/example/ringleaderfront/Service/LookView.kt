package com.example.ringleaderfront.Service

interface LookView {
    fun onGetReviewSuccess(code: Int,result:List<LookReview>)
    fun onGetReviewFailure(code: Int, message: String)
}