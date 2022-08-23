package com.example.ringleaderfront.Splash

import android.animation.Animator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.ringleaderfront.FirstActivity
import com.example.ringleaderfront.MainActivity
import com.example.ringleaderfront.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }

}