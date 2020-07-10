package com.mhtmalpani.superextensions.primitive

import android.annotation.SuppressLint
import java.net.URI
import java.net.URLEncoder
import java.security.MessageDigest
import java.util.regex.Pattern

/**
 * Extensions for Urls.
 * Fetch the Host
 */
fun String.extractDomain(): String = URI(this).host


fun String.encodeToUTF8(): String = URLEncoder.encode(this, "UTF-8")


/**
 * Generates a Hash 256 of a String
 */
fun String.hash256(): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val digest = messageDigest.digest(this.toByteArray())
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}

/**
 * Convert a given string to TitleCase
 */
@SuppressLint("DefaultLocale")
fun String.convertToTitleCase(excludeSet: List<String> = emptyList()): String? {
    val result: String?
    try {
        val exclude = if (excludeSet.isEmpty()) {
            " "
        } else {
            excludeSet.joinToString("|")
        }
        val stringBuffer = StringBuffer()
        val matcher = Pattern.compile("(?!\\b($exclude)\\b)\\b([a-zA-Z])([a-zA-Z]*)").matcher(this)
        while (matcher.find()) {
            matcher.appendReplacement(
                stringBuffer,
                matcher.group(2).toUpperCase() + matcher.group(3).toLowerCase()
            )
        }
        result = matcher.appendTail(stringBuffer).toString()
    } catch (e: Exception) {
        return null
    }

    return result
}