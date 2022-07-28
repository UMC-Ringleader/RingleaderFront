package com.example.ringleaderfront

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ringleaderfront.databinding.ActivityLoginBinding
import com.example.ringleaderfront.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupNextButton.setOnClickListener {
            val myIntent: Intent = Intent(this,UsernameActivity::class.java)
            startActivity(myIntent)
        }

    }
}