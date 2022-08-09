package com.example.ringleaderfront
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ringleaderfront.WriteReview.ReviewSelectSearchActivity
import com.example.ringleaderfront.databinding.FragmentMainPageBinding
import kotlinx.android.synthetic.main.review_card.view.*

class MainPageFragment : Fragment() {
    lateinit var town:Town

    //retrofit
    lateinit var themeReviews:List<ThemeReview>



    //WriteActivity에서 bundle객체 받기
    companion object {
        const val ARG_NAME = "name"
        fun newInstance(name: String): MainPageFragment {
            Log.d("order_newInstance","newInstance 함수 들어옴")
            val fragment = MainPageFragment()
            val bundle = Bundle().apply {
                putString(ARG_NAME, name)
                Log.d("newInstance_bundle_name",name)
            }
            fragment.arguments = bundle
            return fragment
        }
//        fun newInstance(name: String) = MainPageFragment().apply {
//            arguments = Bundle().apply {
//                putString(ARG_NAME, name)
//                Log.d("newInstance_bundle_name",name)
//
//            }
//            Log.d("order_newInstance_finish","finish")
//        }

//        fun newInstance(name: String) = this.apply {
//            val args = Bundle()
//            args.putString(ARG_NAME, name)
//            this.arguments = args
//            Log.d("this.arguments",this.arguments.toString())
//            return this
//        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val binding=FragmentMainPageBinding.inflate(inflater,container,false)
        Log.d("order_OnCreateView","OnCreateView실행")
//        arguments?.let{
//            val name=it.getString(ARG_NAME)
//            Log.d("apply_bundle?",name.toString())
//        }
        //val name=arguments?.getString(ARG_NAME)
        //Log.d("ApplyBundle?",name.toString())

        //retrofit
//        lifecycleScope.launchWhenCreated {
//            val response=try{
//                RetrofitClass.reviewApi.getReviews(100)
//            }catch(e:IOException){
//                Log.e(TAG,"IOException,you might not have internet connection")
//                return@launchWhenCreated
//            }catch(e:HttpException){
//                Log.e(TAG,"HTTPException,unexpected response")
//                return@launchWhenCreated
//            }
//            if(response.isSuccessful&& response.body()!=null){
//
//                themeReviews=response.body()!!
//            }else{
//
//                Log.e(TAG,"Response not successful")
//            }
//        }

        //WriteActivity에서 bundle로 넘겨준 리뷰객체 받기

//        var bundle = this.arguments
//        Log.d("bundle상태",bundle.toString())
//        if (bundle != null) {
//            val bundleDefault=requireArguments().getString("bundleD")
//            Log.d("bundleIsNotNull",bundleDefault.toString())
//            //val writeReview=requireArguments()!!.getSerializable("writeReview")
//            //Log.d("bundle_in_fragment",writeReview.toString())
//        }



        //Dummytown
        var dummyTown1=Town("경리단길", ArrayList())

        var themeReview1=ThemeReview("상점1","catagory1",null, ArrayList(),"image1","text1")
        var themeReview2=ThemeReview("상점2","catagory2",null,ArrayList(),"image2","text2")
        var themeReview3=ThemeReview("상점3","catagory3",null,ArrayList(),"image3","text3")

        themeReview1.tags?.add(tag("tag1_1"))
        themeReview1.tags?.add(tag("tag1_2"))
        themeReview1.tags?.add(tag("tag1_3"))

        themeReview2.tags?.add(tag("tag2_1"))
        themeReview2.tags?.add(tag("tag2_2"))
        themeReview2.tags?.add(tag("tag2_3"))

        themeReview3.tags?.add(tag("tag3_1"))
        themeReview3.tags?.add(tag("tag3_2"))
        themeReview3.tags?.add(tag("tag3_3"))

        dummyTown1.themeReviews?.add(themeReview1)
        dummyTown1.themeReviews?.add(themeReview2)
        dummyTown1.themeReviews?.add(themeReview3)


        Log.d("dummyTown1.themeReviews.size",dummyTown1.themeReviews?.size.toString())

        val reviewView1=getLayoutInflater().inflate(R.layout.review_card,null)
        reviewView1.review_card_store_name_tv.setText(dummyTown1.themeReviews?.get(0)?.storeName.toString())
        if (reviewView1.getParent() != null) {
            (reviewView1.getParent() as ViewGroup).removeView(reviewView1) // <- fix
        }
        binding.mainPageLl.addView(reviewView1)

        val reviewView2=getLayoutInflater().inflate(R.layout.review_card,null)
        reviewView2.review_card_store_name_tv.setText(dummyTown1.themeReviews?.get(1)?.storeName.toString())
        if (reviewView2.getParent() != null) {
            (reviewView2.getParent() as ViewGroup).removeView(reviewView2) // <- fix
        }
        binding.mainPageLl.addView(reviewView2)

        val reviewView3=getLayoutInflater().inflate(R.layout.review_card,null)
        reviewView3.review_card_store_name_tv.setText(dummyTown1.themeReviews?.get(2)?.storeName.toString())
        if (reviewView3.getParent() != null) {
            (reviewView3.getParent() as ViewGroup).removeView(reviewView3) // <- fix
        }
        binding.mainPageLl.addView(reviewView3)

//floating button 글 작성 버튼
        binding.extendedFab.setOnClickListener {
//            val intent = Intent(getActivity(), WriteActivity::class.java)
//            startActivity(intent)
            val intent = Intent(getActivity(), ReviewSelectSearchActivity::class.java)
            startActivity(intent)

        }




        //각 리뷰에 onClickListener 달아주기
        val icount: Int =  binding.mainPageLl.getChildCount()
        for (i in 0 until icount) {
            binding.mainPageLl.getChildAt(i).setOnClickListener{
                val intent = Intent(getActivity(), ReviewinfoActivity::class.java)
                Log.d("view_select",i.toString()+"번째 view 선택!")
                intent.putExtra("review_content",dummyTown1.themeReviews?.get(i))
                startActivity(intent)
            }
        }



//        binding.mainPageLl.setOnClickListener {
//            val intent = Intent(getActivity(), ReviewinfoActivity::class.java)
//            startActivity(intent)
//
//        }


        //bundle 값 받기

//        val townBundle = arguments
//        if (townBundle != null) {
//            val data = townBundle.getSerializable("townBundle")
//
//        }

        //bundle에서 값 꺼내기



        val townBundleName=arguments?.getString("townBundleName")
        //Log.d("townBundleName fragment에서 꺼내기",townBundleName.toString())


        return binding.root
    }
}