package com.mhtmalpani.superextensions

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

fun Intent.intentOf(vararg params: Pair<String, Any?>): Intent {
    val intent = this

    for (pair in params) {
        val (key, value) = pair
        when (value) {
            is Boolean -> putExtra(key, value)
            is Byte -> putExtra(key, value)
            is Char -> putExtra(key, value)
            is Short -> putExtra(key, value)
            is Int -> putExtra(key, value)
            is Long -> putExtra(key, value)
            is Float -> putExtra(key, value)
            is Double -> putExtra(key, value)
            is String -> putExtra(key, value)
            is CharSequence -> putExtra(key, value)
            is Parcelable -> putExtra(key, value)
            is BooleanArray -> putExtra(key, value)
            is ByteArray -> putExtra(key, value)
            is CharArray -> putExtra(key, value)
            is DoubleArray -> putExtra(key, value)
            is FloatArray -> putExtra(key, value)
            is IntArray -> putExtra(key, value)
            is LongArray -> putExtra(key, value)
            is Array<*> -> {
                @Suppress("UNCHECKED_CAST")
                when {
                    value.isArrayOf<Parcelable>() -> putExtra(
                        key,
                        value as Array<out Parcelable>
                    )
                    value.isArrayOf<CharSequence>() -> putExtra(
                        key,
                        value as Array<out CharSequence>
                    )
                    value.isArrayOf<String>() -> putExtra(
                        key,
                        value as Array<out String>
                    )
                    else -> throw Exception("Unsupported bundle component (${value.javaClass})")
                }
            }
            is ShortArray -> putExtra(key, value)
            is Bundle -> putExtra(key, value)
            is Serializable -> putExtra(key, value)
            else -> throw Exception("Unsupported bundle component (${value?.javaClass})")
        }
    }

    return intent
}