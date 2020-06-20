package com.mhtmalpani.superextensions.examples

import com.mhtmalpani.superextensions.primitive.orFalse
import com.mhtmalpani.superextensions.primitive.orTrue

class BooleanExamples {

    fun tryBoolean() {

        val data: Boolean? = null

        println(data.orTrue())
        println(data.orFalse())
    }
}