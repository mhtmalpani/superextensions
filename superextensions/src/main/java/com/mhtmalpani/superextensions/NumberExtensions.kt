package com.mhtmalpani.superextensions

fun Int?.orZero(): Int = this ?: 0

fun Long?.orZero(): Long = this ?: 0L

fun Double?.orZero(): Double = this ?: 0.0