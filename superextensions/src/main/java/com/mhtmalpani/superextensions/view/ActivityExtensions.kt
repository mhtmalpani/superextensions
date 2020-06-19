package com.mhtmalpani.superextensions.view

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T : Activity> Context.intentOf(
    vararg params: Pair<String, Any?>
): Intent = Intent(this, T::class.java).apply { intentOf(*params) }


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