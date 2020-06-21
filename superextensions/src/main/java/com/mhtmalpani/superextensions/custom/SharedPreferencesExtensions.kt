package com.mhtmalpani.superextensions.custom

import android.content.SharedPreferences

/**
 * Run a series of shared preferences methods asynchronously
 *
 * Usage:
 *      sharedPreferences.execute {
 *          putString(KEY, VALUE)
 *      }
 */
fun SharedPreferences.execute(body: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    body(editor)
    editor.apply()
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