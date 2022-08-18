package com.example.ringleaderfront.WriteReview

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.*
import com.example.ringleaderfront.R
import com.example.ringleaderfront.databinding.ActivityReviewWriteBinding
import java.time.LocalDate


class ReviewWriteActivity : AppCompatActivity() {

    lateinit var binding:ActivityReviewWriteBinding
    private lateinit var launcher: ImagePickerLauncher
    private lateinit var launcher2: ImagePickerLauncher
    private lateinit var selectedImages:ArrayList<Uri>

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReviewWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
        selectedImages=ArrayList<Uri>()




        var reviewText: String = ""
        binding.writeBtn.isEnabled = false

        binding.reviewEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.letterCount.text = "0 / 10,000"
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                reviewText = binding.reviewEditText.text.toString()
                binding.writeBtn.isEnabled = reviewText.isNotEmpty()
                binding.letterCount.text = reviewText.length.toString()+ " / 10,000"
            }

            override fun afterTextChanged(p0: Editable?) {
                reviewText = binding.reviewEditText.text.toString()
                binding.letterCount.text = reviewText.length.toString()+ " / 10,000"
            }

        })


        binding.writeBtn.setOnClickListener {
            Toast.makeText(this, "글을 확인하세요", Toast.LENGTH_SHORT).show()

            val titleText = binding.titleEditText.text.toString()
            var tagText = binding.tagEditText.text.toString()
            val reviewText = binding.reviewEditText.text.toString()
            var query = intent.getStringExtra("query")
            val todayDate :LocalDate= LocalDate.now()


            val writeToCheck = Intent(this, ReviewWriteCheckActivity::class.java)
            writeToCheck.putExtra("titleTxt", titleText)
            writeToCheck.putExtra("tagTxt", tagText)
            writeToCheck.putExtra("reviewTxt", reviewText)
            writeToCheck.putExtra("UriArray", selectedImages)
            writeToCheck.putExtra("query", query)
            writeToCheck.putExtra("date", todayDate.toString())
            startActivity(writeToCheck)

        }





        //+버튼 누르면 imagePicker불러와서 사진 선택
        imagePickerLoad1()

    }


    private fun imagePickerLoad1() {

        //imagePicker 생성해서 이미지 url 매개변수로 넘기기
        launcher = registerImagePicker { result ->
            if (result.isNotEmpty()) {
                for(i in result){
                    selectedImages.add(i.uri)
                }
                setProfileImage(selectedImages)
                Log.d("selectedImages",selectedImages.size.toString())

            }

        }

        if(binding.reviewWriteLlIb.visibility==View.VISIBLE) {
            binding.reviewWriteLlIb.setOnClickListener {
                binding.reviewWriteLlIb.visibility = View.GONE
                val config = ImagePickerConfig {
                    mode = ImagePickerMode.MULTIPLE // 1장만 선택
                    isFolderMode = false
                    isIncludeVideo = false
                    arrowColor = Color.WHITE
                    imageTitle = "이미지를 선택하세요"
                    doneButtonText = "추가" // returnMode가 NONE인 경우 표시됨
                    isShowCamera = true
                    returnMode = ReturnMode.NONE

                }
                launcher.launch(config)

            }
        }

    }

    private fun plusBtnLoad(width:Int,height:Int,imagesLayout:LinearLayout) {
        val plusBtn = ImageButton(this@ReviewWriteActivity)
        val ButtonLayoutParams = LinearLayout.LayoutParams(
            width,
            height,
        )
        plusBtn.layoutParams = ButtonLayoutParams
        plusBtn.setImageResource(R.drawable.ic_baseline_add_24)
        plusBtn.setBackgroundColor(Color.TRANSPARENT)
        imagesLayout.addView(plusBtn)

        //imagepicker

//        launcher2 = registerImagePicker { result ->
//            if (result.isNotEmpty()) {
//                for(i in result){
//                    selectedImages.add(i.uri)
//                }
//                setProfileImage(selectedImages)
//                Log.d("selectedImages",selectedImages.size.toString())
//            }
//
//        }
//        plusBtn.setOnClickListener {
//            val config = ImagePickerConfig {
//                mode = ImagePickerMode.MULTIPLE // 1장만 선택
//                isFolderMode = false
//                isIncludeVideo = false
//                arrowColor = Color.WHITE
//                imageTitle = "이미지를 선택하세요"
//                doneButtonText = "추가" // returnMode가 NONE인 경우 표시됨
//                isShowCamera = true
//                returnMode = ReturnMode.NONE
//
//            }
//            launcher.launch(config)
//        }



    }


    private fun setProfileImage(imageUris: ArrayList<Uri>) {
        val imagesLayout: LinearLayout = findViewById(R.id.review_write_ll)
        imagesLayout.removeAllViews()
        val width = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            140f,
            resources.displayMetrics
        ).toInt()
        val height = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            145f,
            resources.displayMetrics
        ).toInt()
        for (i in imageUris) {
            val selectedImage = ImageView(this@ReviewWriteActivity)
            val imageLayoutParams = LinearLayout.LayoutParams(
                width,
                height,
            )
            selectedImage.layoutParams = imageLayoutParams
            Glide.with(this).load(i).into(selectedImage)
            imagesLayout.addView(selectedImage)
        }
        plusBtnLoad(width,height,imagesLayout)

    }
}