package com.mhtmalpani.superextensions.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

fun EditText.afterTextChanged(afterTextChanged: (data: String) -> Unit) {

    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun EditText.onTextChanged(onTextChanged: (charSequence: CharSequence, start: Int, before: Int, after: Int) -> Unit) {

    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            onTextChanged.invoke(p0, p1, p2, p3)
        }

        override fun afterTextChanged(editable: Editable) {
        }
    })
}

fun EditText.beforeTextChanged(beforeTextChanged: (charSequence: CharSequence, start: Int, before: Int, after: Int) -> Unit) {

    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
            beforeTextChanged.invoke(p0, p1, p2, p3)
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable) {
        }
    })
}