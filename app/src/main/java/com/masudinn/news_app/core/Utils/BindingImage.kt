package com.masudinn.news_app.core.Utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.masudinn.news_app.R
import com.squareup.picasso.Picasso

@BindingAdapter("android:setImageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    if (url.isNullOrBlank()) return
    Picasso.get()
        .load(url)
        .placeholder(R.color.colorAccent)
        .fit()
        .centerCrop()
        .into(view)
}