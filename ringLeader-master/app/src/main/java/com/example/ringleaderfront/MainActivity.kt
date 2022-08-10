package com.example.ringleaderfront


import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.ringleaderfront.databinding.ActivityMainBinding
import com.example.ringleaderfront.databinding.MyToolbarBinding

class MainActivity : AppCompatActivity() {

    //public var writeFlag by Delegates.notNull<Int>()

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarBinding:MyToolbarBinding
    var mContext: Context? = null
    var writeToMain=0
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        mContext=this
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbarBinding=MyToolbarBinding.inflate(layoutInflater)
        initBottomNavigation()
        Log.d("writeToMain?",writeToMain.toString())
//        if(Var.==1){
//            transactionMainPageFragment()
//        }


        //setUpTabBar()
        //getmyIntent()



        //상단 툴바
//        setContentView(R.layout.my_toolbar)
//        setSupportActionBar(myToolbar)


    }


    fun setWriteToMain(){
        writeToMain=1
        Log.d("writeToMain","setWriteToMain에서 값"+writeToMain.toString())
    }

    fun transactionMainPageFragment() {
        val name="main_activity_apply_bundle"

        val fragment: MainPageFragment = MainPageFragment.newInstance(name)
        val header = getLayoutInflater().inflate(R.layout.activity_main, null, false)
        supportFragmentManager.beginTransaction().replace(
            R.id.main_frm,
            fragment
        ).commit()


    }

    private fun initBottomNavigation() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frm, MainPageFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.MainPageFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, MainPageFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                R.id.SearchFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, SearchFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.RankFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, RankFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.ProfileFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.main_frm, ProfileFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

    }


    private fun getmyIntent() {
        var townIntent:Town?=null
        townIntent = intent.getSerializableExtra("town_name") as Town?
        Log.d("townIntent",townIntent?.name+"MainActivity에 전달 완료")
        //sendToFragment(townIntent)
        //툴바 장소text set
        //Log.d("toolbar_text", toolbarBinding.myToolbarTv.text.toString())
        // Log.d("townIntent.name",townIntent?.name!!)
        var myToolbarTv=findViewById<TextView>(R.id.my_toolbar_tv)
        val mUpdateUITimerTask = Runnable { // do whatever you want to change here, like:
            //toolbarBinding.myToolbarTv.text=townIntent.name
            myToolbarTv.text=townIntent?.name
        }
        val mHandler = Handler()
        mHandler.postDelayed(mUpdateUITimerTask,  1);




    }

    private fun sendToFragment(townIntent:Town) {
        //지금 작동이 안됨.
        val MainPageFragment1 = MainPageFragment()
        val bundle = Bundle()

        bundle.putString("townBundleName", townIntent.name);
        MainPageFragment1.arguments=bundle
        Log.d("townBundle 생성","townBundle 생성 완료")
        val transaction = supportFragmentManager.beginTransaction()

        //transaction.replace(R.id.viewPager,MainPageFragment1).commit()




    }


//    private fun setUpTabBar()
//    {
//        val adapter = TabPageAdapter(this, tabLayout.tabCount)
//        viewPager.adapter = adapter
//
//        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback()
//        {
//            override fun onPageSelected(position: Int) {
//                tabLayout.selectTab(tabLayout.getTabAt(position))
//            }
//        })
//
//        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener
//        {
//            override fun onTabSelected(tab: TabLayout.Tab)
//            {
//                viewPager.currentItem = tab.position
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {}
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {}
//        })
//    }



    override fun onResume(){
        super.onResume()
        getmyIntent()
        //getWriteIntent()
    }

//    private fun getWriteIntent() {
//        Log.d("getWriteIntent함수","진입")
//        //writeIntent 받기
//        if(writeFlag!=0) {
//            Log.d("getWriteIntent","writeFlag!=0")
//            var writeIntent: ThemeReview? = null
//            writeIntent = intent.getSerializableExtra("write_intent") as ThemeReview?
//            Log.d("writeIntent",writeIntent!!.storeName+"전달완료")
//        }
//    }

}