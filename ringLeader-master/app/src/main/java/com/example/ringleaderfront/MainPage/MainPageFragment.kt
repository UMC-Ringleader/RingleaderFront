package com.example.ringleaderfront.MainPage

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.ringleaderfront.Data.*
import com.example.ringleaderfront.R
import com.example.ringleaderfront.WriteReview.ReviewSelectSearchActivity
import com.example.ringleaderfront.databinding.FragmentMainPageBinding
import com.example.ringleaderfront.Service.*
import kotlinx.android.synthetic.main.review_card.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.Serializable

class MainPageFragment : Fragment() ,Serializable,LookView{
    lateinit var town: Town

    //retrofit
    lateinit var themeReviews:List<ThemeReview>

    lateinit var binding:FragmentMainPageBinding

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

    }


    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentMainPageBinding.inflate(inflater,container,false)
        Log.d("order_OnCreateView","OnCreateView실행")
        //lookReviews()
        getReviews()


//
//        //Dummytown
//        var dummyTown1= Town("이태원", ArrayList())
////        var storeName:String,
////        var catagory:String,
////        var user: User?,
////        var title:String,
////        var tags:ArrayList<tag>?,
////        var images:ArrayList<Uri>,
////        var review_text:String
//
//        //review1
//        //미리 images 배열 생성
//        val review1_uri1 = Uri.parse("android.resource://com.example.ringleaderfront/drawable/spain1")
//        val review1_uri2 = Uri.parse("android.resource://com.example.ringleaderfront/drawable/spain2")
//        val review1_uri3 = Uri.parse("android.resource://com.example.ringleaderfront/drawable/spain3")
//        val images_arr=ArrayList<Uri>()
//        images_arr.add(review1_uri1)
//        images_arr.add(review1_uri2)
////        images_arr.add(review1_uri3)
//
//
//        //미리 tags 배열 생성
//        val tags_arr=ArrayList<tag>()
//        tags_arr.add(tag("#이태원_스페인요리"))
//        tags_arr.add(tag("#이태원맛집"))
//        tags_arr.add(tag("#스페인"))
//
//
//
//        var review1= ThemeReview("타파스바",
//            "음식점",
//            "Royce",
//            "2022-08-15",
//            "스페인 요리의 정석과도 같은 곳",
//            tags_arr,
//            images_arr,
//            "지나갈 때마다 가 보고 싶었던... 이태원 스페인요리 전문점 타파스바! 너무너무 기대하면서 갔습니다 ㅎㅎ 그 맛은.. 정말 글로 설명하기 어려워요 진짜 우와"
//        )
//
//
//        //review2
//        //미리 images 배열 생성
//        val images2_arr=ArrayList<Uri>()
//
//        //미리 tags 배열 생성
//        val tags2_arr=ArrayList<tag>()
//        tags2_arr.add(tag("#카레"))
//        tags2_arr.add(tag("#이태원카레집"))
//        tags2_arr.add(tag("#튀김카레"))
//        tags2_arr.add(tag("#이태원_카레"))
//
//        var review2= ThemeReview("어제의 카레",
//            "음식점",
//            null,
//            "2022-08-15",
//            "카레만 맛있어도 될텐데",
//            tags2_arr,
//            images2_arr,
//            "카레 맛집으로 소개 받고 간 어제의 카레,\n"+
//                    "이곳의 가장 큰 특징은 함꼐 나오는 돈까스마저 수준급...\n"
//        )
//
//
//        //review3
//        //미리 images 배열 생성
//        val images3_arr=ArrayList<Uri>()
//
//        //미리 tags 배열 생성
//        val tags3_arr=ArrayList<tag>()
//        tags3_arr.add(tag("#이자카야"))
//        tags3_arr.add(tag("#이태원_이자카야"))
//        tags3_arr.add(tag("#꼬치맛집"))
//
//
//        var review3= ThemeReview("야키토리 고우",
//            "주점",
//            null,
//            "2022-08-15",
//            "이게 바로 술이 술술 들어가는 분위기?!",
//            tags3_arr,
//            images3_arr,
//            "이태원 골목을 차지하고 있던 이자카야 집 야키토리 고우,\n" +
//                    "항상 보기만 하다가 드디어 들어가 봤다!\n"
//
//        )
//
//
//
//
//        dummyTown1.themeReviews?.add(review1)
//        dummyTown1.themeReviews?.add(review2)
//        dummyTown1.themeReviews?.add(review3)
//
//
//        Log.d("dummyTown1.themeReviews.size",dummyTown1.themeReviews?.size.toString())
//
//
//
//        //review 객체 review_i라는 변수로 받아오기
//        val review_cnt=dummyTown1.themeReviews?.size
//        Log.d("review_cnt",review_cnt.toString())
//        if(review_cnt!=0){
//            for(i in 0 until dummyTown1.themeReviews?.size!!){
//                val reviewView1=getLayoutInflater().inflate(R.layout.review_card,null)
//
//                //card에 margin부여
//                val cardLayoutParams=LinearLayout.LayoutParams(  LinearLayout.LayoutParams.WRAP_CONTENT,
//                    LinearLayout.LayoutParams.WRAP_CONTENT)
//                cardLayoutParams.setMargins(30,35,30,35)
//                reviewView1.layoutParams=cardLayoutParams
//
//
//
//                val review_i=dummyTown1.themeReviews?.get(i)
//
//                //card에 카테고리별 색상 부여
//                var category=review_i?.catagory
//                when(category){
//                    "음식점"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_restaurant))
//                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_restaurant))}
//                    "카페"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_cafe))
//                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_cafe)) }
//                    "주점"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_pub))
//                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_pub)) }
//                    "놀거리"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_play))
//                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_play)) }
//                    "생활시설"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_life))
//                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_life)) }
//                }
//
//
//                reviewView1.review_card_store_name_tv.setText(review_i?.storeName.toString())
//                reviewView1.review_card_category_tv.setText(review_i?.catagory)
//                reviewView1.review_card_review_title_tv.setText(review_i?.title)
//                reviewView1.review_card_user.setText(review_i?.user)
//
//
//                reviewView1.review_card_tags_ll.removeAllViews()
//                //tag부분
//                review_i?.tags?.let{
//                    for(tag in it) {
//                        val layoutParams=LinearLayout.LayoutParams(  LinearLayout.LayoutParams.WRAP_CONTENT,
//                            LinearLayout.LayoutParams.WRAP_CONTENT)
//
//                        val tagTextView = TextView(context)
//                        tagTextView.text=tag.tagText
//                        tagTextView.setTextColor(ContextCompat.getColor(requireContext() , R.color.main_color))
//                        reviewView1.review_card_tags_ll.addView(tagTextView)
//                    }
//                }
//
//
//                reviewView1.review_card_review_text_tv.setText(review_i?.review_text)
//
//                //이미지 개수에 따라 linearlayout의 view가 달라짐
//                Log.d("images_arr_cnt",images_arr.size.toString())
//
//                if(review_i?.images?.size==0){
//                    reviewView1.review_card_images_ll.removeAllViews()
//                }
//                else if(review_i?.images?.size==1){
//                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
//                }
//                else if(review_i?.images?.size==2){
//                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
//                    reviewView1.review_card_image2.setImageURI(review_i?.images?.get(1))
//                }
//                else{
//                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
//                    reviewView1.review_card_image2.setImageURI(review_i?.images?.get(1))
//                    reviewView1.review_card_image3.setImageURI(review_i?.images?.get(2))
//
//                }
//
//                if (reviewView1.getParent() != null) {
//                    (reviewView1.getParent() as ViewGroup).removeView(reviewView1) // <- fix
//                }
//                binding.mainPageLl.addView(reviewView1)
//            }
//        }
//
//
//
//
//floating button 글 작성 버튼
        binding.extendedFab.setOnClickListener {
//            val intent = Intent(getActivity(), WriteActivity::class.java)
//            startActivity(intent)
            val intent = Intent(getActivity(), ReviewSelectSearchActivity::class.java)
            startActivity(intent)

        }
//
//
//
//        //각 리뷰에 onClickListener 달아주기
//        val icount: Int =  binding.mainPageLl.getChildCount()
//        for (i in 0 until icount) {
//            binding.mainPageLl.getChildAt(i).setOnClickListener{
//                val intent = Intent(getActivity(), ReviewinfoActivity::class.java)
////                Log.d("view_select",i.toString()+"번째 view 선택!")
//                intent.putExtra("review_content",dummyTown1.themeReviews?.get(i))
//                startActivity(intent)
//            }
//        }

        return binding.root
    }

    private fun getReviews() {
        Log.d("serverData","getReviews()")

        val LookReviewService = LookReviewService()
        LookReviewService.setLookView(this)
        LookReviewService.getReviews() //레트로핏 호출


    }

    override fun onGetReviewSuccess(code: Int, result: List<LookReview>) {
        var list1= mutableListOf<ServerLookReview>()
        Log.d("serverData","OnGetReviewSuccess()")

        //region에 있는 리뷰들 ServerLookReview 객체로 region의 list1에 추가
        for(i in 0..(result?.size-1)) {
            val userId1=result?.get(i).userId
            val nickName1 = result?.get(i).nickName
            val userContribution1 = result?.get(i).userContribution
            val title1 = result?.get(i).title
            val reviewTitle1=result?.get(i).reviewTitle
            val category1 = result?.get(i).category
            val hashtag11 = result?.get(i).hashtag1
            val hashtag21 = result?.get(i).hashtag2
            val hashtag31 = result?.get(i).hashtag3
            val contents1 = result?.get(i).contents
            val imgUrls1 = result?.get(i).imgUrls
            val reviewFeedBacks1=result?.get(i).reviewFeedBacks
            val bookmarked1=result?.get(i).bookmarked
            var ServerLookReview1 = ServerLookReview(
                userId1,
                nickName1,
                userContribution1,
                title1,
                reviewTitle1,
                category1,
                hashtag11,
                hashtag21,
                hashtag31,
                contents1,
                imgUrls1,
                reviewFeedBacks1,
                bookmarked1
            )
            list1.add(ServerLookReview1)
        }

        var ServerRegion= ServerRegion(15,list1)

        //카드뷰 리뷰별로 동적으로 생성
        val review_cnt=ServerRegion.ServerLookReviews?.size
        Log.d("serverData",review_cnt.toString())
        if(review_cnt!=0){
            for(i in 0 until ServerRegion.ServerLookReviews?.size!!){
                val reviewView1=getLayoutInflater().inflate(R.layout.review_card,null)

                //card에 margin부여
                val cardLayoutParams=LinearLayout.LayoutParams(  LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)
                cardLayoutParams.setMargins(30,35,30,35)
                reviewView1.layoutParams=cardLayoutParams



                val review_i=ServerRegion.ServerLookReviews?.get(i)

                //card에 카테고리별 색상 부여
                var category=review_i?.category
                Log.d("categoty",category.toString())
                when(category){
                    "음식점"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_restaurant))
                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_restaurant))}
                    "카페"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_cafe))
                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_cafe)) }
                    "술집"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_pub))
                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_pub)) }
                    "여행"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_play))
                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_play)) }
                    "기타"->{reviewView1.review_card_category_ll.setBackgroundColor(resources.getColor(R.color.cata_life))
                        reviewView1.review_card_cl.setBackgroundColor(resources.getColor(R.color.back_life)) }
                }


                reviewView1.review_card_store_name_tv.setText(review_i?.title)
                reviewView1.review_card_category_tv.setText(review_i?.category)
                reviewView1.review_card_review_title_tv.setText(review_i?.reviewTitle)
                reviewView1.review_card_user.setText(review_i?.nickName)



                reviewView1.review_card_tags_ll.removeAllViews()
                //tag부분
//                review_i?.tags?.let{
//                    for(tag in it) {
//                        val layoutParams=LinearLayout.LayoutParams(  LinearLayout.LayoutParams.WRAP_CONTENT,
//                            LinearLayout.LayoutParams.WRAP_CONTENT)
//
//                        val tagTextView = TextView(context)
//                        tagTextView.text=tag.tagText
//                        tagTextView.setTextColor(ContextCompat.getColor(requireContext() , R.color.main_color))
//                        reviewView1.review_card_tags_ll.addView(tagTextView)
//                    }
//                }

                review_i?.hashtag1.let{
                    //for(tag in it) {
                        val layoutParams=LinearLayout.LayoutParams(  LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT)

                        val tagTextView = TextView(context)
                        tagTextView.text=it
                        tagTextView.setTextColor(ContextCompat.getColor(requireContext() , R.color.main_color))
                        reviewView1.review_card_tags_ll.addView(tagTextView)
                    //}
                }
                review_i?.hashtag2.let{
                    //for(tag in it) {
                    val layoutParams=LinearLayout.LayoutParams(  LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)

                    val tagTextView = TextView(context)
                    tagTextView.text=it
                    tagTextView.setTextColor(ContextCompat.getColor(requireContext() , R.color.main_color))
                    reviewView1.review_card_tags_ll.addView(tagTextView)
                    //}
                }
                review_i?.hashtag3.let{
                    //for(tag in it) {
                    val layoutParams=LinearLayout.LayoutParams(  LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT)

                    val tagTextView = TextView(context)
                    tagTextView.text=it
                    tagTextView.setTextColor(ContextCompat.getColor(requireContext() , R.color.main_color))
                    reviewView1.review_card_tags_ll.addView(tagTextView)
                    //}
                }

                reviewView1.review_card_review_text_tv.setText(review_i?.contents)

            //이미지는 보류
            //이미지 개수에 따라 linearlayout의 view가 달라짐
//                Log.d("images_arr_cnt",images_arr.size.toString())
//
//                if(review_i?.images?.size==0){
//                    reviewView1.review_card_images_ll.removeAllViews()
//                }
//                else if(review_i?.images?.size==1){
//                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
//                }
//                else if(review_i?.images?.size==2){
//                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
//                    reviewView1.review_card_image2.setImageURI(review_i?.images?.get(1))
//                }
//                else{
//                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
//                    reviewView1.review_card_image2.setImageURI(review_i?.images?.get(1))
//                    reviewView1.review_card_image3.setImageURI(review_i?.images?.get(2))
//
//                }
//
                if (reviewView1.getParent() != null) {
                    (reviewView1.getParent() as ViewGroup).removeView(reviewView1) // <- fix
                }
                binding.mainPageLl.addView(reviewView1)
            }
        }




//        Log.d("serverData",result?.get(0).userName.toString())
//        Log.d("serverData",result?.get(0).userContribution.toString())
//        Log.d("serverData",result?.get(0).category.toString())
//        Log.d("serverData",result?.get(0).hashtag1.toString())
//        Log.d("serverData",result?.get(0).hashtag2.toString())
//        Log.d("serverData",result?.get(0).hashtag3.toString())
//        Log.d("serverData",result?.get(0).contents.toString())
//        Log.d("serverData",result?.get(0).imgUrls.size.toString())


    }

    override fun onGetReviewFailure(code: Int, message: String) {
        TODO("Not yet implemented")
    }

}