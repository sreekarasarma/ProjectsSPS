package com.example.lazystaggeredgridcompose

import androidx.annotation.DrawableRes

data class Movie(
    @DrawableRes val imageResId: Int,
    val name: String,
    val genre: String,
    val plot: String
)
