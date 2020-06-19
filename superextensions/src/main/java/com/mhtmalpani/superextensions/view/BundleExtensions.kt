package com.mhtmalpani.superextensions.view

import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

fun bundleOf(vararg params: Pair<String, Any?>): Bundle {
    val bundle = Bundle()
    for (pair in params) {
        val (key, value) = pair
        when (value) {
            null -> bundle.putSerializable(key, null)
            is Boolean -> bundle.putBoolean(key, value)
            is Byte -> bundle.putByte(key, value)
            is Char -> bundle.putChar(key, value)
            is Short -> bundle.putShort(key, value)
            is Int -> bundle.putInt(key, value)
            is Long -> bundle.putLong(key, value)
            is Float -> bundle.putFloat(key, value)
            is Double -> bundle.putDouble(key, value)
            is String -> bundle.putString(key, value)
            is CharSequence -> bundle.putCharSequence(key, value)
            is Parcelable -> bundle.putParcelable(key, value)
            is BooleanArray -> bundle.putBooleanArray(key, value)
            is ByteArray -> bundle.putByteArray(key, value)
            is CharArray -> bundle.putCharArray(key, value)
            is DoubleArray -> bundle.putDoubleArray(key, value)
            is FloatArray -> bundle.putFloatArray(key, value)
            is IntArray -> bundle.putIntArray(key, value)
            is LongArray -> bundle.putLongArray(key, value)
            is Array<*> -> {
                @Suppress("UNCHECKED_CAST")
                when {
                    value.isArrayOf<Parcelable>() -> bundle.putParcelableArray(
                        key,
                        value as Array<out Parcelable>
                    )
                    value.isArrayOf<CharSequence>() -> bundle.putCharSequenceArray(
                        key,
                        value as Array<out CharSequence>
                    )
                    value.isArrayOf<String>() -> bundle.putStringArray(
                        key,
                        value as Array<out String>
                    )
                    else -> throw Exception("Unsupported bundle component (${value.javaClass})")
                }
            }
            is ShortArray -> bundle.putShortArray(key, value)
            is Bundle -> bundle.putBundle(key, value)
            is Serializable -> bundle.putSerializable(key, value)
            else -> throw Exception("Unsupported bundle component (${value.javaClass})")
        }
    }

    return bundle
}