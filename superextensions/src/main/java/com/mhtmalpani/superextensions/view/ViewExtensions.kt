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
 *
 * @param id the XML id that needs to be bound
 *
 * Usage:
 *      private val profileImage by bindView<ImageView>(R.id.profile_image)
 *      or
 *      private val profileImage: ImageView by bindView(R.id.profile_image)
 *      or
 *      private val profileImage: ImageView by bindView(profile_image)
 */
inline fun <reified T : View> Activity.bindView(@IdRes id: Int): Lazy<T> =
    lazy { findViewById<T>(id) }


/**
 * Binds a view with @param id to variable
 * This can be used within Fragment Scope
 *
 * @param id the XML id that needs to be bound
 *
 * Usage:
 *      private val profileImage by bindView<ImageView>(R.id.profile_image)
 *      or
 *      private val profileImage: ImageView by bindView(R.id.profile_image)
 *      or
 *      private val profileImage: ImageView by bindView(profile_image)
 */
inline fun <reified T : View> Fragment.bindView(@IdRes id: Int): Lazy<T> = lazy {
    view?.findViewById<T>(id) ?: throw Exception("Fragment is not initialized")
}


/**
 * Binds a view with @param id to variable
 * This can be used within a View Scope
 *
 * @param id the XML id that needs to be bound
 *
 * Usage:
 *      root_view.bindView<TextView>(R.id.username)
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


/**
 * Toggles the visibility of a view
 * Change from Visible to Invisible and vice versa
 *
 * Usage:
 *      submit_button.toggleVisibility()
 */
fun View.toggleVisibility() {
    visibility = if (visibility == View.VISIBLE) View.INVISIBLE else View.VISIBLE
}


/**
 * Iterate through each child of a ViewGroup and runs a lambda on them
 *
 * Usage:
 *      root_view.iterateChildren { index, child ->
 *          //Your custom logic
 *      }
 */
fun ViewGroup.iterateChildren(body: (index: Int, child: View) -> Unit) {
    for (index in 0 until childCount) {
        body(index, getChildAt(index))
    }
}