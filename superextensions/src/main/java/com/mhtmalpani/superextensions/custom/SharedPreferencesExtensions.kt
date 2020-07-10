package com.mhtmalpani.superextensions.custom

import android.annotation.SuppressLint
import android.content.SharedPreferences

/**
 * Run a series of shared preferences methods asynchronously
 *
 * Usage:
 *      sharedPreferences.execute {
 *          putString(KEY, VALUE)
 *      }
 *
 *      or
 *
 *      sharedPreferences.execute(commit = true) {
 *          putString(KEY, VALUE)
 *      }
 *
 */
@SuppressLint("ApplySharedPref")
fun SharedPreferences.execute(
    commit: Boolean = false,
    body: SharedPreferences.Editor.() -> Unit
): Boolean {
    val editor = edit()
    body(editor)

    return if (commit) {
        editor.commit()
    } else {
        editor.apply()
        true
    }
}


/**
 * Run a series of shared preferences methods synchronously
 *
 * Usage:
 *      val commit = sharedPreferences.executeSynchronous {
 *          putString(KEY, VALUE)
 *      }
 *
 * @return commit value of the execution by SharedPreferences
 */
fun SharedPreferences.executeSynchronous(body: SharedPreferences.Editor.() -> Unit): Boolean {
    val editor = edit()
    body(editor)
    return editor.commit()
}