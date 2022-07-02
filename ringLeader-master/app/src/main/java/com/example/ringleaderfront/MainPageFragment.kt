package com.example.ringleaderfront
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ringleaderfront.databinding.FragmentMainPageBinding
import kotlinx.android.synthetic.main.review_card.view.*


class MainPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding=FragmentMainPageBinding.inflate(inflater,container,false)
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


        binding.extendedFab.setOnClickListener {
            val intent = Intent(getActivity(), WriteActivity::class.java)
            startActivity(intent)

        }

        binding.mainPageLl.setOnClickListener {
            val intent = Intent(getActivity(), ReviewinfoActivity::class.java)
            startActivity(intent)

        }


        return binding.root
    }
}