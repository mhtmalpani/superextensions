package com.mhtmalpani.superextensions.custom

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment


fun Fragment.toast(any: Any, time: Int = Toast.LENGTH_SHORT) = activity?.toast(any.toString(), time)

fun Fragment.toast(@StringRes stringRes: Int, time: Int = Toast.LENGTH_SHORT) =
    activity?.toast(getString(stringRes), time)

fun Fragment.toast(message: CharSequence, time: Int = Toast.LENGTH_SHORT) =
    activity?.toast(message, time)

fun Context.toast(any: Any, time: Int = Toast.LENGTH_SHORT) = toast(any.toString(), time)

fun Context.toast(@StringRes stringRes: Int, time: Int = Toast.LENGTH_SHORT) =
    toast(getString(stringRes), time)

fun Context.toast(message: CharSequence, time: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, time).show()