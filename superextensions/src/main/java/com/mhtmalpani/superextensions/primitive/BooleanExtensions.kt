package com.mhtmalpani.superextensions.primitive

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}

fun Boolean?.orTrue(): Boolean {
    return this ?: true
}

fun Boolean.flip(): Boolean {
    return !this
}