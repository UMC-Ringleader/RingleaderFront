package com.example.ringleaderfront

import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.ringleaderfront.WriteReview.ReviewSelectSearchActivity
import com.example.ringleaderfront.databinding.FragmentMainPageBinding
import kotlinx.android.synthetic.main.review_card.view.*

class MainPageFragment : Fragment() {
    lateinit var town: Town

    //retrofit
    lateinit var themeReviews: List<ThemeReview>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainPageBinding.inflate(inflater, container, false)
        Log.d("order_OnCreateView", "OnCreateView실행")
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

//        var dummyTown1 = Town("경리단길", ArrayList())

//        var tagExample = "tag1 tag2 tag3"
//        var tagExampe_split = tagExample.split(" ")
//        var themeReview1 = ThemeReview(
//            "제목1",
//            "상점1",
//            "catagory1",
//            null,
//            tagExampe_split,
//            "2022-0n-0n",
//            "text1"
//        )
//        var themeReview2 = ThemeReview(
//            "제목2",
//            "상점2",
//            "catagory2",
//            null,
//            tagExampe_split,
//            "2022-0n-0n",
//            "text2"
//        )
//        var themeReview3 = ThemeReview(
//            "제목3",
//            "상점3",
//            "catagory3",
//            null,
//            tagExampe_split,
//            "2022-0n-0n",
//            "text3"
//        )

//
//
//        dummyTown1.themeReviews?.add(themeReview1)
//        dummyTown1.themeReviews?.add(themeReview2)
//        dummyTown1.themeReviews?.add(themeReview3)


        //Log.d("dummyTown1.themeReviews.size", dummyTown1.themeReviews?.size.toString())
//
//        val reviewView1 = getLayoutInflater().inflate(R.layout.review_card, null)
//        reviewView1.review_card_name.setText(dummyTown1.themeReviews?.get(0)?.storeName.toString())
//        if (reviewView1.getParent() != null) {
//            (reviewView1.getParent() as ViewGroup).removeView(reviewView1) // <- fix

        var dummyTown1=Town("이태원", ArrayList())
//        var storeName:String,
//        var catagory:String,
//        var user: User?,
//        var title:String,
//        var tags:ArrayList<tag>?,
//        var images:ArrayList<Uri>,
//        var review_text:String

        //review1
        //미리 images 배열 생성
        val review1_uri1 = Uri.parse("android.resource://com.example.ringleaderfront/drawable/spain1")
        val review1_uri2 = Uri.parse("android.resource://com.example.ringleaderfront/drawable/spain2")
        val review1_uri3 = Uri.parse("android.resource://com.example.ringleaderfront/drawable/spain3")
        val images_arr=ArrayList<Uri>()
        images_arr.add(review1_uri1)
        images_arr.add(review1_uri2)
//        images_arr.add(review1_uri3)


        //미리 tags 배열 생성
        val tags_arr=ArrayList<tag>()
        tags_arr.add(tag("#이태원_스페인요리"))
        tags_arr.add(tag("#이태원맛집"))
        tags_arr.add(tag("#스페인"))



        var review1=ThemeReview("타파스바",
            "음식점",
            null,
            "스페인 요리의 정석과도 같은 곳",
            tags_arr,
            images_arr,
            "지나갈 때마다 가 보고 싶었던... \n" +
                    "이태원 스페인요리 전문점 타파스바! \n"
            )


        //review2
        //미리 images 배열 생성
        val images2_arr=ArrayList<Uri>()

        //미리 tags 배열 생성
        val tags2_arr=ArrayList<tag>()
        tags2_arr.add(tag("#이태원_스페인요리"))
        tags2_arr.add(tag("#이태원맛집"))
        tags2_arr.add(tag("#스페인"))

        var review2=ThemeReview("어제의 카레",
            "음식점",
            null,
            "카레만 맛있어도 될텐데",
            tags2_arr,
            images2_arr,
            "카레 맛집으로 소개 받고 간 어제의 카레,\n"+
                    "이곳의 가장 큰 특징은 함꼐 나오는 돈까스마저 수준급...\n"
        )


        dummyTown1.themeReviews?.add(review1)
        dummyTown1.themeReviews?.add(review2)


        Log.d("dummyTown1.themeReviews.size",dummyTown1.themeReviews?.size.toString())



        //review 객체 review_i라는 변수로 받아오기
        val review_cnt=dummyTown1.themeReviews?.size
        Log.d("review_cnt",review_cnt.toString())
        if(review_cnt!=0){
            for(i in 0 until dummyTown1.themeReviews?.size!!){
                val reviewView1=getLayoutInflater().inflate(R.layout.review_card,null)
                val review_i=dummyTown1.themeReviews?.get(i)
                reviewView1.review_card_store_name_tv.setText(review_i?.storeName.toString())
                reviewView1.review_card_category_tv.setText(review_i?.catagory)
                reviewView1.review_card_review_title_tv.setText(review_i?.title)
                reviewView1.review_card_tags_ll.removeAllViews()
                //tag부분
    //        for(i in dummyTown1.themeReviews?.get(0).tags){
    //
    //            reviewView1.review_card_tags_ll.addView()
    //        }

                reviewView1.review_card_review_text_tv.setText(review_i?.review_text)

                //이미지 개수에 따라 linearlayout의 view가 달라짐
                Log.d("images_arr_cnt",images_arr.size.toString())

                if(review_i?.images?.size==0){
                    reviewView1.review_card_images_ll.removeAllViews()
                }
                else if(review_i?.images?.size==1){
                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
                }
                else if(review_i?.images?.size==2){
                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
                    reviewView1.review_card_image2.setImageURI(review_i?.images?.get(1))
                }
                else{
                    reviewView1.review_card_image1.setImageURI(review_i?.images?.get(0))
                    reviewView1.review_card_image2.setImageURI(review_i?.images?.get(1))
                    reviewView1.review_card_image3.setImageURI(review_i?.images?.get(2))

                }

                if (reviewView1.getParent() != null) {
                    (reviewView1.getParent() as ViewGroup).removeView(reviewView1) // <- fix
                }
                binding.mainPageLl.addView(reviewView1)
            }

        }


        val reviewView2 = getLayoutInflater().inflate(R.layout.review_card, null)
        reviewView2.review_card_name.setText(dummyTown1.themeReviews?.get(1)?.storeName.toString())
        if (reviewView2.getParent() != null) {
            (reviewView2.getParent() as ViewGroup).removeView(reviewView2) // <- fix
        }
        binding.mainPageLl.addView(reviewView2)

        val reviewView3 = getLayoutInflater().inflate(R.layout.review_card, null)
        reviewView3.review_card_name.setText(dummyTown1.themeReviews?.get(2)?.storeName.toString())
        if (reviewView3.getParent() != null) {
            (reviewView3.getParent() as ViewGroup).removeView(reviewView3) // <- fix
        }
        binding.mainPageLl.addView(reviewView3)



//        val reviewView2=getLayoutInflater().inflate(R.layout.review_card,null)
//        reviewView2.review_card_store_name_tv.setText(dummyTown1.themeReviews?.get(1)?.storeName.toString())
//        if (reviewView2.getParent() != null) {
//            (reviewView2.getParent() as ViewGroup).removeView(reviewView2) // <- fix
//        }
//        binding.mainPageLl.addView(reviewView2)
//
//        val reviewView3=getLayoutInflater().inflate(R.layout.review_card,null)
//        reviewView3.review_card_store_name_tv.setText(dummyTown1.themeReviews?.get(2)?.storeName.toString())
//        if (reviewView3.getParent() != null) {
//            (reviewView3.getParent() as ViewGroup).removeView(reviewView3) // <- fix
//        }
//        binding.mainPageLl.addView(reviewView3)


//floating button 글 작성 버튼
        binding.extendedFab.setOnClickListener {
//            val intent = Intent(getActivity(), WriteActivity::class.java)
//            startActivity(intent)
            val intent = Intent(getActivity(), ReviewSelectSearchActivity::class.java)
            startActivity(intent)



        }


        //각 리뷰에 onClickListener 달아주기
        val icount: Int = binding.mainPageLl.getChildCount()
        for (i in 0 until icount) {
            binding.mainPageLl.getChildAt(i).setOnClickListener {
                val intent = Intent(getActivity(), ReviewinfoActivity::class.java)
                Log.d("view_select", i.toString() + "번째 view 선택!")
                intent.putExtra("review_content", dummyTown1.themeReviews?.get(i))
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


        val townBundleName = arguments?.getString("townBundleName")
        //Log.d("townBundleName fragment에서 꺼내기",townBundleName.toString())







        //각 리뷰에 onClickListener 달아주기
//        val icount: Int =  binding.mainPageLl.getChildCount()
//        for (i in 0 until icount) {
//            binding.mainPageLl.getChildAt(i).setOnClickListener{
//                val intent = Intent(getActivity(), ReviewinfoActivity::class.java)
//                Log.d("view_select",i.toString()+"번째 view 선택!")
//                intent.putExtra("review_content",dummyTown1.themeReviews?.get(i))
//                startActivity(intent)
//            }
//        }


        return binding.root
    }
}