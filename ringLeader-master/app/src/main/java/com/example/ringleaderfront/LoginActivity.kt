package com.example.ringleaderfront

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ringleaderfront.databinding.ActivityLoginBinding
import com.example.ringleaderfront.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginSignupButton.setOnClickListener {
            val myIntent: Intent = Intent(this,SignupActivity::class.java)
            startActivity(myIntent)
        }

        binding.loginLoginButton.setOnClickListener {
            val emailPwIntent:Intent=Intent(this,TownActivity::class.java)
            startActivity(emailPwIntent)
        }
    }


}