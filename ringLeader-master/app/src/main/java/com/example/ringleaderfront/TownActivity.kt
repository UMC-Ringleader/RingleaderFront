package com.example.ringleaderfront

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ringleaderfront.databinding.ActivityMainBinding
import com.example.ringleaderfront.databinding.ActivityTownBinding
import kotlinx.android.synthetic.main.activity_town.*

class TownActivity: AppCompatActivity() {
    lateinit var towns:ArrayList<Town>
    private lateinit var binding:ActivityTownBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTownBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DummyTown()
        setTownSpinner()

//        town_recentVisit_btn.setOnClickListener {
//            val myIntent : Intent = Intent(this, MainActivity :: class.java)
//            startActivity(myIntent)
//        }


    }

    private fun DummyTown() {
        towns = ArrayList<Town>()
        val town1=Town("경리단길",null)
        val town2=Town("가로수길",null)
        towns.add(town1)
        towns.add(town2)

        Log.d("towns 요소 출력",towns.size.toString())
    }

    private fun setTownSpinner() {

        val itemList = listOf("아래에서 골목을 선택해주세요",towns.get(0).name, towns.get(1).name)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)

        binding.townSpinner.adapter = adapter
        binding.townSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position != 0) Toast.makeText(this@TownActivity, itemList[position], Toast.LENGTH_SHORT).show()
                if(position!=0) {

                    val myIntent: Intent = Intent(this@TownActivity, MainActivity::class.java)
                        .apply { this.putExtra("town_name", towns.get(position-1)) }
                    startActivity(myIntent)
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


    }
}