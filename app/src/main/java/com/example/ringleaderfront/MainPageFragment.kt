package com.example.ringleaderfront

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.ringleaderfront.databinding.FragmentMainPageBinding
import kotlinx.android.synthetic.main.fragment_main_page.view.*
import kotlinx.android.synthetic.main.review_card.view.*


class MainPageFragment : Fragment() {
    lateinit var binding:FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMainPageBinding.inflate(inflater,container,false)
        val reviewView1=getLayoutInflater().inflate(R.layout.review_card,null)


        if (reviewView1.getParent() != null) {
            (reviewView1.getParent() as ViewGroup).removeView(reviewView1) // <- fix
        }
        binding.mainPageLl.addView(reviewView1)

        val reviewView2=getLayoutInflater().inflate(R.layout.review_card,null)
        reviewView2.review_card_name.setText("정통집")
        if (reviewView2.getParent() != null) {
            (reviewView2.getParent() as ViewGroup).removeView(reviewView2) // <- fix
        }
        binding.mainPageLl.addView(reviewView2)

        val reviewView3=getLayoutInflater().inflate(R.layout.review_card,null)
        reviewView3.review_card_name.setText("윙스터디")
        if (reviewView3.getParent() != null) {
            (reviewView3.getParent() as ViewGroup).removeView(reviewView3) // <- fix
        }
        binding.mainPageLl.addView(reviewView3)

        return binding.root


    }

    override fun onStart() {

            //'글 작성'버튼 눌렀을 때 writeFragment으로 화면이 넘어가야 하는데 안넘어감..

//        //글 작성 버튼 화면 전환
        if(binding.mainPageLl.extended_fab!=null) {
            binding.mainPageLl.extended_fab.setOnClickListener {
                val fragment = WriteFragment()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.main_page_fl, fragment)?.commit()
            }
        }


        super.onStart()
    }

}