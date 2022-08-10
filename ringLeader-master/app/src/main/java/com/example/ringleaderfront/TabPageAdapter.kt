package com.example.ringleaderfront

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ringleaderfront.MainPage.MainPageFragment
import com.example.ringleaderfront.SearchPage.SearchFragment


class TabPageAdapter(activity: FragmentActivity, private val tabCount: Int) : FragmentStateAdapter(activity)
{
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment
    {
        return when (position)
        {
            0 -> MainPageFragment()
            1 -> SearchFragment()
            2 -> RankFragment()
            3-> ProfileFragment()
            else -> MainPageFragment()
        }
    }

}