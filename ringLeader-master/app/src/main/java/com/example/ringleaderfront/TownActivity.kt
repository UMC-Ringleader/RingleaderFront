package com.example.ringleaderfront

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_town.*

class TownActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town)

        town_recentVisit_btn.setOnClickListener {
            val myIntent : Intent = Intent(this, MainActivity :: class.java)
            startActivity(myIntent)
        }
    }
}