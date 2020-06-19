package com.mhtmalpani.superextensions

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

inline fun <reified T : View> Activity.bindView(@IdRes id: Int): Lazy<T> =
    lazy { findViewById<T>(id) }

inline fun <reified T : View> Fragment.bindView(@IdRes id: Int): Lazy<T> = lazy {
    view?.findViewById<T>(id) ?: throw Exception("Fragment is not initialized")
}

inline fun <reified T : View> View.bindView(@IdRes id: Int): Lazy<T> = lazy { findViewById<T>(id) }

