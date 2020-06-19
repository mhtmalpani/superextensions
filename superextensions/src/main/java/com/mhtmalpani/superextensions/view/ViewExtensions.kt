package com.mhtmalpani.superextensions.view

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment

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

