package com.mhtmalpani.superextensions

import android.content.SharedPreferences

fun SharedPreferences.execute(body: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    body(editor)
    editor.apply()
}