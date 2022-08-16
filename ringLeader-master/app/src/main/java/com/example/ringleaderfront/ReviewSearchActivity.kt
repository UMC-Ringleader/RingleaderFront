//package com.example.ringleaderfront
//
//import android.os.Bundle
//import android.view.ContextThemeWrapper
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import com.example.ringleaderfront.databinding.ActivityReviewSearchBinding
//
//class ReviewSearchActivity : AppCompatActivity() {
//    lateinit var binding: ActivityReviewSearchBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityReviewSearchBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        createPopularSearchBtn("파스타")
//        createPopularSearchBtn("샐러드")
//        createPopularSearchBtn("칵테일")
//        createPopularSearchBtn("케이크")
//        createPopularSearchBtn("이자카야")
//
//        createRecentSearchBtn("홍대밥집")
//        createRecentSearchBtn("디저트맛집")
//        createRecentSearchBtn("식재료마트")
//        createRecentSearchBtn("훈제치킨")
//        createRecentSearchBtn("통닭")
//        createRecentSearchBtn("도시락배달")
//
//
//
//
//
//    }
//    private fun createPopularSearchBtn(btnText:String) {
//        val newStyle = ContextThemeWrapper(this, R.style.popular_search_btn)
//        val dynamicButton = Button(newStyle)
//        dynamicButton.text = btnText
//        binding.popularSearchBtnView.addView(dynamicButton)}
//
//    private fun createRecentSearchBtn(btnText:String) {
//        val newStyle = ContextThemeWrapper(this, R.style.recent_search_btn)
//        val dynamicButton = Button(newStyle)
//        dynamicButton.text = btnText
//        binding.recentSearchBtnView.addView(dynamicButton)}
//
//
//}