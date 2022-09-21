package com.example.random.util
import android.widget.ImageView
import com.bumptech.glide.Glide

fun  ImageView.loadAnimalImage(image:String){
    Glide.with(this).load(image)
        .into(this)
}


