package com.example.mytestapp.viewpager.data

import androidx.annotation.DrawableRes
import com.example.mytestapp.R

data class PagerItem(
    @DrawableRes val image : Int,
    val description : String
)
 val dataList = listOf(
     PagerItem(R.drawable.baseline_accessibility_24, "PAGE 1"),
     PagerItem(R.drawable.baseline_accessibility_24, "PAGE 2"),
     PagerItem(R.drawable.baseline_accessibility_24, "PAGE 3")
 )