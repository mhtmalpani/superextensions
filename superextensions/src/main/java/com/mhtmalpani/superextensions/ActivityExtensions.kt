package com.mhtmalpani.superextensions

import android.app.Activity
import android.content.Context
import android.content.Intent

inline fun <reified T : Activity> Context.intentOf(
    vararg params: Pair<String, Any?>
): Intent = Intent(this, T::class.java).apply { intentOf(*params) }


fun Activity.bindStringArgument(key: String): Lazy<String> = lazy {
    this.intent?.extras?.getString(key)
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}