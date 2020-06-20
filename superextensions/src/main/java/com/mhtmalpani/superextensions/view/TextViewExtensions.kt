package com.mhtmalpani.superextensions.view

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.annotation.StringRes

@SuppressLint("ResourceType")
fun TextView.setTextResource(@StringRes resId: Int) {
    text = context.getString(resId)
}