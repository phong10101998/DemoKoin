package com.sun.demokoin.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.sun.demokoin.R

fun ImageView.loadUrl(imageApi: String?) {
    Glide.with(context)
        .load(imageApi)
        .error(R.drawable.null_recipe)
        .placeholder(R.drawable.null_recipe)
        .into(this)
}
