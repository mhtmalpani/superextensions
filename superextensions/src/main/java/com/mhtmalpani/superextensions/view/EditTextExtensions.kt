package com.mhtmalpani.superextensions.view

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 * Sets a listener to Edit Text after a text has changed
 *
 * Usage:
 *      usernameEditText.afterTextChanged { data ->
 *          //You custom logic to do after text changed
 *      }
 */
fun EditText.afterTextChanged(afterTextChanged: (data: String) -> Unit = {}) {

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


/**
 * Sets a listener to Edit Text on text change
 *
 * Usage:
 *      usernameEditText.onTextChanged { charSequence, start, before, end ->
 *          //You custom logic to do after text changed
 *      }
 */
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


/**
 * Sets a listener to Edit Text before text changes
 *
 * Usage:
 *      usernameEditText.beforeTextChanged { charSequence, start, before, end ->
 *          //You custom logic to do after text changed
 *      }
 */
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