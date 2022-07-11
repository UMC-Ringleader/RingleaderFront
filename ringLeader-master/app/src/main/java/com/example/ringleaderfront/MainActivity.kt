package com.example.ringleaderfront


import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.ringleaderfront.databinding.ActivityMainBinding
import com.example.ringleaderfront.databinding.MyToolbarBinding
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_first.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarBinding:MyToolbarBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbarBinding=MyToolbarBinding.inflate(layoutInflater)
        setUpTabBar()
        //getmyIntent()



        //상단 툴바
//        setContentView(R.layout.my_toolbar)
//        setSupportActionBar(myToolbar)
    }






    private fun getmyIntent() {
        val townIntent = intent.getSerializableExtra("town_name") as Town
        Log.d("townIntent",townIntent.name+"MainActivity에 전달 완료")
        //sendToFragment(townIntent)
        //툴바 장소text set
        Log.d("toolbar_text", toolbarBinding.myToolbarTv.text.toString())
        Log.d("townIntent.name",townIntent.name)
        var myToolbarTv=findViewById<TextView>(R.id.my_toolbar_tv)
        val mUpdateUITimerTask = Runnable { // do whatever you want to change here, like:
            //toolbarBinding.myToolbarTv.text=townIntent.name
            myToolbarTv.text=townIntent.name
        }
        val mHandler = Handler()
        mHandler.postDelayed(mUpdateUITimerTask,  1000);



    }

    private fun sendToFragment(townIntent:Town) {
        val MainPageFragment1 = MainPageFragment()
        val bundle = Bundle()

        bundle.putString("townBundleName", townIntent.name);
        MainPageFragment1.arguments=bundle
        Log.d("townBundle 생성","townBundle 생성 완료")
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.viewPager,MainPageFragment1).commit()




    }


    private fun setUpTabBar()
    {
        val adapter = TabPageAdapter(this, tabLayout.tabCount)
        viewPager.adapter = adapter

        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback()
        {
            override fun onPageSelected(position: Int) {
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener
        {
            override fun onTabSelected(tab: TabLayout.Tab)
            {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }



   override fun onResume(){
        super.onResume()
        getmyIntent()
   }

}