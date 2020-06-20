package com.mhtmalpani.superextensions.view

import android.os.Parcelable
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

inline fun <reified T : Fragment> instanceOf(vararg params: Pair<String, Any?>): T =
    T::class.java.newInstance().apply {
        arguments = bundleOf(*params)
    }


///////////////////////////////////////////////////////////////////////////////////////////////////
//                                      Bind Arguments
///////////////////////////////////////////////////////////////////////////////////////////////////

inline fun <reified T : Any> Fragment.bindArgument(key: String): Lazy<T> = lazy {
    arguments?.get(key) as? T ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

inline fun <reified T : Any> Fragment.bindSerializableArgument(key: String): Lazy<T> = lazy {
    arguments?.getSerializable(key) as? T
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

inline fun <reified T : Parcelable> Fragment.bindParcelableArgument(key: String): Lazy<T> = lazy {
    arguments?.getParcelable(key) as? T
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}


///////////////////////////////////////////////////////////////////////////////////////////////////
//                                      FragmentManager
///////////////////////////////////////////////////////////////////////////////////////////////////

fun FragmentManager.transaction(body: FragmentTransaction.() -> Unit) {
    beginTransaction().also {
        body(it)
    }.commit()
}