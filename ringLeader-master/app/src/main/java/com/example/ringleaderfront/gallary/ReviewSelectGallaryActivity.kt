package com.example.ringleaderfront.Gallary

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.esafirm.imagepicker.features.*
import com.example.ringleaderfront.WriteReview.ReviewWriteActivity
import com.example.ringleaderfront.databinding.ActivityReviewSelectGallaryBinding


class ReviewSelectGallaryActivity : AppCompatActivity() {

    private lateinit var binding:ActivityReviewSelectGallaryBinding
    private lateinit var launcher: ImagePickerLauncher
    private lateinit var selectedImages:ArrayList<Uri>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityReviewSelectGallaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        selectedImages=ArrayList<Uri>()


        launcher = registerImagePicker { result ->
            if (result.isNotEmpty()) {

                val selectedImage = result.first() // 1장만 선택하기 때문에
                val selectedImage2=result.get(1)
                val selectedImage3=result.get(2)
                Log.d("selectedImage",selectedImage.uri.toString())
                Log.d("selectedImage",selectedImage2.uri.toString())
                Log.d("selectedImage",selectedImage3.uri.toString())
                selectedImages.add(selectedImage.uri)
                selectedImages.add(selectedImage2.uri)
                selectedImages.add(selectedImage3.uri)
                // 이미지 Uri를 통해 이미지뷰에 이미지를 넣어준다.
                //setProfileImage(selectedImage.uri)
                setProfileImage(selectedImages)
            }
        }

        binding.reviewSelectGallaryImageSelectBtn.setOnClickListener {
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

        binding.reviewSelectGallaryConfirmBtn.setOnClickListener {
            val gallaryToWrite : Intent = Intent(this, ReviewWriteActivity :: class.java)
            if(selectedImages!=null) {
                gallaryToWrite.putExtra("UriArray", selectedImages)
            }
            startActivity(gallaryToWrite)
        }


    }

    private fun setProfileImage(imageUris: ArrayList<Uri>) {
        Glide.with(this).load(imageUris.get(0)).into(binding.reviewSelectGallarySelectedIv1)
        Glide.with(this).load(imageUris.get(1)).into(binding.reviewSelectGallarySelectedIv2)
        Glide.with(this).load(imageUris.get(2)).into(binding.reviewSelectGallarySelectedIv3)
    }



}