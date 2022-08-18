package com.example.ringleaderfront.SearchPage

import android.R
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView.*
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import com.example.ringleaderfront.WriteReview.ReviewWriteActivity
import com.example.ringleaderfront.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment() : Fragment() {

    lateinit var binding: FragmentSearchBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        createPopularSearchBtn("파스타")
        createPopularSearchBtn("샐러드")
        createPopularSearchBtn("칵테일")
        createPopularSearchBtn("케이크")
        createPopularSearchBtn("이자카야")

        createRecentSearchBtn("홍대밥집")
        createRecentSearchBtn("디저트맛집")
        createRecentSearchBtn("식재료마트")
        createRecentSearchBtn("훈제치킨")
        createRecentSearchBtn("통닭")
        createRecentSearchBtn("도시락배달")



        return binding.root
    }


    //인기검색어 생성
    private fun createPopularSearchBtn(btnText: String) {
        //var newStyle = ContextThemeWrapper(context, R.style.popular_search_btn)
        val dynamicButton = Button(context)
        dynamicButton.text = btnText
        //dynamicButton.background = resources.getDrawable(round_btn)
        binding.popularSearchBtnView.addView(dynamicButton)


    }

    //최근검색어 생성
    private fun createRecentSearchBtn(btnText: String) {
        //var newStyle = ContextThemeWrapper(this, R.style.recent_search_btn)
        val dynamicButton = Button(context)
        dynamicButton.text = btnText
        binding.recentSearchBtnView.addView(dynamicButton)
    }
}


