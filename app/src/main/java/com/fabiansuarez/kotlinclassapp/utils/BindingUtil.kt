package com.fabiansuarez.kotlinclassapp.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseMethod
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
}

@InverseMethod("stringToDouble")
fun doubleToString(value: Double): String {
    return value.toString()
}

@InverseMethod("doubleToString")
fun stringToDouble(value: String): Double {
    if (value==""){
        return 0.0
    }
    return value.toDouble()
}