package com.mhtmalpani.superextensions

import androidx.fragment.app.Fragment

inline fun <reified T : Fragment> instanceOf(vararg params: Pair<String, Any?>): T =
    T::class.java.newInstance().apply { arguments = bundleOf(*params) }

inline fun <reified T : Any> Fragment.bindArgument(key: String): Lazy<T> = lazy {
    arguments?.get(key) as? T ?: throw IllegalArgumentException("Argument not passed for key: $key")
}