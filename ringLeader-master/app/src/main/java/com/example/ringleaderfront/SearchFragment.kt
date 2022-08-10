package com.example.ringleaderfront

import android.R
import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView.*
import androidx.fragment.app.Fragment
import com.example.ringleaderfront.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

//        val inflater = super.onGetLayoutInflater(savedInstanceState)
//        val contextThemeWrapper: Context = ContextThemeWrapper(requireContext(), R.style.yourCustomTheme)
//        return inflater.cloneInContext(contextThemeWrapper)


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

        return binding.root

    }

//    private fun createPopularSearchBtn(btnText: String) {
//        val newStyle =
//            ContextThemeWrapper(this, com.example.ringleaderfront.R.style.popular_search_btn)
//        val dynamicButton = Button(newStyle)
//        dynamicButton.text = btnText
//        binding.popularSearchBtnView.addView(dynamicButton)
//    }
//
//    private fun createRecentSearchBtn(btnText: String) {
//        val savedInstanceState: Bundle?
//        val inflater = super.onGetLayoutInflater(savedInstanceState)
//        val themedInflater = inflater.cloneInContext(ContextThemeWrapper(requireActivity(), R.style.recent_search_btn))
//        val dynamicButton = Button(newStyle)
//        dynamicButton.text = btnText
//        binding.recentSearchBtnView.addView(dynamicButton)
//    }


}

