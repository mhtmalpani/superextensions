package com.mhtmalpani.superextensions

import java.net.URI
import java.net.URLEncoder
import java.security.MessageDigest

fun String.extractDomain(): String = URI(this).host

fun String.encodeToUTF8(): String = URLEncoder.encode(this, "UTF-8")

fun String.hash256(): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val digest = messageDigest.digest(this.toByteArray())
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}

