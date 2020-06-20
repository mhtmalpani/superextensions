package com.mhtmalpani.superextensions.view

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


///////////////////////////////////////////////////////////////////////////////////////////////////
//                                          Bind View
///////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * Binds a view with @param id to variable
 * This can be used within Activity Scope
 */
inline fun <reified T : View> Activity.bindView(@IdRes id: Int): Lazy<T> =
    lazy { findViewById<T>(id) }


/**
 * Binds a view with @param id to variable
 * This can be used within Fragment Scope
 */
inline fun <reified T : View> Fragment.bindView(@IdRes id: Int): Lazy<T> = lazy {
    view?.findViewById<T>(id) ?: throw Exception("Fragment is not initialized")
}


/**
 * Binds a view with @param id to variable
 * This can be used within a View Scope
 */
inline fun <reified T : View> View.bindView(@IdRes id: Int): Lazy<T> = lazy { findViewById<T>(id) }


///////////////////////////////////////////////////////////////////////////////////////////////////
//                                          Inflation
///////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * Inflate layout from Context
 */
fun Context.inflate(
    @LayoutRes res: Int,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): View =
    LayoutInflater.from(this).inflate(res, parent, attachToParent)


/**
 * Inflate layout from View
 */
fun View.inflate(
    @LayoutRes res: Int,
    parent: ViewGroup? = null,
    attachToParent: Boolean = false
): View =
    LayoutInflater.from(context).inflate(res, parent, attachToParent)


fun View.toggleVisibility(isShown: Boolean) {
    visibility = if (visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
}


fun ViewGroup.iterateChildren(body: (index: Int, child: View) -> Unit) {
    for (index in 0 until childCount) {
        body(index, getChildAt(index))
    }
}