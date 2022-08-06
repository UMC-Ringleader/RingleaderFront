package com.example.ringleaderfront.WriteReview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter

import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.ringleaderfront.R
import com.example.ringleaderfront.databinding.ActivityLoginBinding
import com.example.ringleaderfront.databinding.ActivityReviewSelectSearchBinding
import com.example.ringleaderfront.gallary.ReviewSelectGallaryActivity

class ReviewSelectSearchActivity : AppCompatActivity() {
    lateinit var binding: ActivityReviewSelectSearchBinding
    lateinit var listAdapter: ArrayAdapter<String>

    // creating array list for listview
    lateinit var storeList: ArrayList<String>;

    // creating variable for searchview
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityReviewSelectSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // initializing list and adding data to list
        var storeList = ArrayList<String>()
        storeList.add("음식점1")
        storeList.add("음식점2")
        storeList.add("음식점3")
        storeList.add("음식점4")

        // initializing list adapter and setting layout
        // for each list view item and adding array list to it.
        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            storeList
        )

        // on below line setting list
        // adapter to our list view.
        binding.reviewSelectSearchLv.adapter = listAdapter

        // on below line we are adding on query
        // listener for our search view.
        searchView=binding.reviewSelectSearchSv
        if (::searchView.isInitialized) {
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.d("onQueryTextSubmit","눌려짐")
                    // on below line we are checking
                    // if query exist or not.
                    if (storeList.contains(query)) {
                        // if query exist within list we
                        // are filtering our list adapter.
                        listAdapter.filter.filter(query)
                        if(query!=null) {
                            Log.d("query?","query is not null")
                            val intent = Intent(
                                this@ReviewSelectSearchActivity,
                                ReviewSelectGallaryActivity::class.java
                            )
                            intent.putExtra("query", query)
                            startActivity(intent)
                        }

                    } else {
                        // if query is not present we are displaying
                        // a toast message as no  data found..
                        Toast.makeText(this@ReviewSelectSearchActivity, "No store found..", Toast.LENGTH_LONG)
                            .show()

                    }
                    return false
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    // if query text is change in that case we
                    // are filtering our adapter with
                    // new text on below line.
                    listAdapter.filter.filter(newText)
                    return false
                }
            })

        }

    }


}