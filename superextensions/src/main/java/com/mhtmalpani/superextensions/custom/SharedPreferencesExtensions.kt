package com.mhtmalpani.superextensions.custom

import android.content.SharedPreferences

fun SharedPreferences.execute(body: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    body(editor)
    editor.apply()
}

fun SharedPreferences.executeSynchronous(body: SharedPreferences.Editor.() -> Unit): Boolean {
    val editor = edit()
    body(editor)
    return editor.commit()
}