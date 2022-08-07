package com.example.ringleaderfront.WriteReview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter

import android.widget.Toast
import androidx.appcompat.widget.SearchView
import com.example.ringleaderfront.R
import com.example.ringleaderfront.Store
import com.example.ringleaderfront.databinding.ActivityLoginBinding
import com.example.ringleaderfront.databinding.ActivityReviewSelectSearchBinding
import com.example.ringleaderfront.gallary.ReviewSelectGallaryActivity

class ReviewSelectSearchActivity : AppCompatActivity() {
    lateinit var binding: ActivityReviewSelectSearchBinding
    lateinit var listAdapter: StoreListViewAdapter

    // creating array list for listview
    lateinit var storeList: ArrayList<Store>

    // creating variable for searchview
    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityReviewSelectSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpData()
        setUpList()
        //setUpOnClickListener()





        // initializing list adapter and setting layout
        // for each list view item and adding array list to it.
//        listAdapter = ArrayAdapter<String>(
//            this,
//            android.R.layout.simple_list_item_1,
//            storeList
//        )



        // on below line we are adding on query
        // listener for our search view.
        searchView=binding.reviewSelectSearchSv
        var storeListString=ArrayList<String>()
        for(i in storeList){
            storeListString.add(i.storeName)
        }
        if (::searchView.isInitialized) {

            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    Log.d("onQueryTextSubmit","눌려짐")
                    // on below line we are checking
                    // if query exist or not.

                    if (storeListString.contains(query)) {
                        // if query exist within list we
                        // are filtering our list adapter.
                        listAdapter.filter.filter(query)
                        if(query!=null) {
                            Log.d("query?","query is not null")

                            val intent = Intent(
                                this@ReviewSelectSearchActivity,
                                ReviewWriteActivity::class.java
                            )

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

    private fun setUpOnClickListener() {
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()){
//
//            public void onItemClick(AdapterView<?> adapterView, View view,int position,long l){
//                Animal selectAnimal=(Animal)listView.getItemAtPosition(position);
//                Intent showDetail=new Intent(getApplicationContext(),DetailActivity.class);
//                showDetail.putExtra("id",selectAnimal.getId())
//            }
//        }

    }

    private fun setUpList() {
        // on below line setting list
        // adapter to our list view.
        listAdapter=StoreListViewAdapter(storeList)
        binding.reviewSelectSearchLv.adapter = listAdapter
    }

    private fun setUpData() {
        // initializing list and adding data to list
        storeList = ArrayList<Store>()
        var store1=Store("음식점1",null)
        var store2=Store("음식점2",null)
        var store3=Store("음식점3",null)
        var store4=Store("음식점4",null)
        storeList.add(store1)
        storeList.add(store2)
        storeList.add(store3)
        storeList.add(store4)

    }


}