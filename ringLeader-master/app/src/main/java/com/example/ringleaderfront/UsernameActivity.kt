package com.example.ringleaderfront

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ringleaderfront.databinding.ActivitySignupBinding
import com.example.ringleaderfront.databinding.ActivityUsernameBinding

class UsernameActivity : AppCompatActivity() {
    lateinit var binding: ActivityUsernameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUsernameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.usernameStartButton.setOnClickListener {
            val myIntent: Intent = Intent(this,TownActivity::class.java)
            startActivity(myIntent)
        }
    }
}