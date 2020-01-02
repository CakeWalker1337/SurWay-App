package com.tenxgames.surway.utils

import android.content.Context
import android.widget.ImageView
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import com.tenxgames.surway.R

fun createCategoryImageView(context: Context, uri: String): ImageView {
    val imageView = ImageView(context)
    val layoutParams = LinearLayout.LayoutParams(
        context.resources.getDimension(R.dimen.survey_category_icon_size).toInt(),
        context.resources.getDimension(R.dimen.survey_category_icon_size).toInt()
    )
    layoutParams.setMargins(0, 0, context.resources.getDimension(R.dimen.margin_1x).toInt(), 0)
    imageView.layoutParams = layoutParams
    Glide.with(imageView).load(uri).placeholder(R.drawable.ic_placeholder_category).into(imageView)
    return imageView
}