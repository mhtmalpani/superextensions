package com.mhtmalpani.superextensions.view

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.annotation.StringRes

/**
 * Sets a text resource to a view
 *
 * Usage:
 *      username.setTextResource(R.string.name)
 */

@SuppressLint("ResourceType")
fun TextView.setTextResource(@StringRes resId: Int) {
    text = context.getString(resId)
}