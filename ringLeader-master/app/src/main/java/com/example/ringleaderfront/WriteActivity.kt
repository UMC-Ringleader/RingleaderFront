package com.example.ringleaderfront

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.example.ringleaderfront.databinding.ActivityWriteBinding

class WriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWriteBinding
    private val fragmentManager = supportFragmentManager
    private lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.writePosting.setOnClickListener {
            val name="apply_bundle"
            val fragment=MainPageFragment.newInstance(name!!)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.main_frm, MainPageFragment())
//                .commit()
//            MainActivity().writeFlag=1
//            Log.d("writeFlag 값",MainActivity().writeFlag.toString())
//            var writeReview=ThemeReview("storeName1w","catagory1w",null,null,"image1w","text1w")
//            val writeIntent : Intent = Intent(this, MainActivity :: class.java)
//            writeIntent.putExtra("write_intent",writeReview)
//            startActivity(writeIntent)
//            finish()
            //Log.d("writePosting","등록버튼 눌림")
//            val fragment = MainPageFragment()
//            val bundle = Bundle()
//            var writeReview=ThemeReview("storeName1w","catagory1w",null,null,"image1w","text1w")
//            //bundle.putSerializable("writeReview",writeReview)
//            bundle.putString("bundleD","bundle기본")
//            fragment.arguments=bundle
//            Log.d("bundleMade",bundle.getString("bundleD").toString())





        }
    }
}