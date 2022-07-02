package com.example.ringleaderfront

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        first_GuestButton.setOnClickListener {
            val myIntent : Intent = Intent(this, TownActivity :: class.java)
            startActivity(myIntent)
        }

        first_LoginButton.setOnClickListener {
            val loginIntent:Intent=Intent(this,LoginActivity::class.java)
            startActivity(loginIntent)
        }


    }
}