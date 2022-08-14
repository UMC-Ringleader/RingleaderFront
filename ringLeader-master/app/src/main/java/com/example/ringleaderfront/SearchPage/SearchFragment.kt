package com.example.ringleaderfront.SearchPage
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.*
import androidx.fragment.app.Fragment
import com.example.ringleaderfront.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentSearchBinding.inflate(inflater,container,false)

        var tags=arrayOf("스페인","와인","빠에야","정원","케이크")
//        val tagsAdapter = ArrayAdapter(
//            requireActivity()!!,
//            R.layout.simple_list_item_1,
//            tags
//        )
//        binding.searchLl.adapter=tagsAdapter

//        binding.searchSv.setOnQueryTextListener(object: OnQueryTextListener,
//            androidx.appcompat.widget.SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                binding.searchSv.clearFocus()
//                if(tags.contains(query)){
//                    //tag를 찾아서 tag가 있으면 해당 뷰를 addView로 보여줌
//                    //tagsAdapter.filter.filter(query)
//                }
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                //tagsAdapter.filter.filter(newText)
//                return false
//            }
//
//        })


        return binding.root
    }
}