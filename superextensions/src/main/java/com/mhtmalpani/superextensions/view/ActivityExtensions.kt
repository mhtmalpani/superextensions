package com.mhtmalpani.superextensions.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import java.io.Serializable

inline fun <reified T : Activity> Context.intentOf(
    vararg params: Pair<String, Any?>
): Intent = Intent(this, T::class.java).apply { intentOf(*params) }

inline fun <reified T : Any> Activity.intentExtra(key: String): Lazy<T> =
    lazy { intent?.extras?.get(key) as T }

/**
 * `extra` would get the extra at runtime when accessing the data.
 * Usage:
 * private val id by extra<String>(EXTRA_ID_KEY)
 *      -> will return String?
 */
inline fun <reified T : Any> Activity.extra(key: String, default: T? = null) = lazy {
    val value = intent?.extras?.get(key)
    if (value is T) value else default
}

/**
 * `extraNotNull` behaves like `extra`, but would crash at runtime if the value was null
 * Usage:
 * private val id by extraNotNull<String>(EXTRA_ID_KEY)
 *      -> will return String
 */
inline fun <reified T : Any> Activity.extraNotNull(key: String, default: T? = null) = lazy {
    val value = intent?.extras?.get(key)
    requireNotNull(if (value is T) value else default) { key }
}


///////////////////////////////////////////////////////////////////////////////////////////////////
//                                      Bind Arguments
///////////////////////////////////////////////////////////////////////////////////////////////////

fun Activity.bindStringArgument(key: String): Lazy<String> = lazy {
    this.intent?.extras?.getString(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

fun Activity.bindIntArgument(key: String): Lazy<Int> = lazy {
    this.intent?.extras?.getInt(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

fun Activity.bindLongArgument(key: String): Lazy<Long> = lazy {
    this.intent?.extras?.getLong(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

fun Activity.bindFloatArgument(key: String): Lazy<Float> = lazy {
    this.intent?.extras?.getFloat(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

fun Activity.bindDoubleArgument(key: String): Lazy<Double> = lazy {
    this.intent?.extras?.getDouble(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

fun Activity.bindBooleanArgument(key: String): Lazy<Boolean> = lazy {
    this.intent?.extras?.getBoolean(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

fun Activity.bindCharArgument(key: String): Lazy<Char> = lazy {
    this.intent?.extras?.getChar(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

fun <T : Parcelable> Activity.bindParcelableArgument(key: String): Lazy<T> = lazy {
    this.intent?.extras?.getParcelable<T>(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}

fun <T : Serializable> Activity.bindSerializableArgument(key: String): Lazy<T> = lazy {
    this.intent?.extras?.getSerializable(key) as? T
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}