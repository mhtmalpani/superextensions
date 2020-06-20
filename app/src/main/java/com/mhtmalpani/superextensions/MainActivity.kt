package com.mhtmalpani.superextensions

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.mhtmalpani.superextensions.view.afterTextChanged
import com.mhtmalpani.superextensions.view.bindView
import com.mhtmalpani.superextensions.view.onTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val title by bindView<TextView>(R.id.title)
    private val subTitle: TextView by bindView(R.id.subTitle)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        custom()
    }

    private fun custom() {
        editText.afterTextChanged {
            println(it)
        }

        editText.onTextChanged { charSequence, start, before, after ->
            println("$charSequence, $start, $before, $after")
        }
    }
}