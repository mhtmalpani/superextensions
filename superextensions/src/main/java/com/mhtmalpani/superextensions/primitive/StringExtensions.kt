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


/**
 * Encodes a given string to UTF-8
 *
 * Usage:
 *      val url = "https://www.example.com?ref=www.github.com&hash=123456789"
 *      println(url.encodeToUTF8())
 *          -> will return https%3A%2F%2Fwww.example.com%3Fref%3Dwww.github.com%26hash%3D123456789
 */
fun String.encodeToUTF8(): String = URLEncoder.encode(this, "UTF-8")


/**
 * Generates a Hash SHA-1 of a String
 *
 * Usage:
 *      val text = "Hello"
 *      println(text.sha1())
 *          -> will print: f7ff9e8b7bb2e09b70935a5d785e0cc5d9d0abf0
 */
fun String.sha1(): String {
    val messageDigest = MessageDigest.getInstance("SHA-1")
    val digest = messageDigest.digest(this.toByteArray())
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}


/**
 * Generates a Hash SHA-256 of a String
 *
 * Usage:
 *      val text = "Hello"
 *      println(text.sha256())
 *          -> will print: 185f8db32271fe25f561a6fc938b2e264306ec304eda518007d1764826381969
 */
fun String.sha256(): String {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val digest = messageDigest.digest(this.toByteArray())
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}


/**
 * Generates a Hash SHA-512 of a String
 *
 * Usage:
 *      val text = "Hello"
 *      println(text.sha512())
 *          -> will print: 3615f80c9d293ed7402687f94b22d58e529b8cc7916f8fac7fddf7fbd5af4cf777d3d795a7a00a16bf7e7f3fb9561ee9baae480da9fe7a18769e71886b03f315
 */
fun String.sha512(): String {
    val messageDigest = MessageDigest.getInstance("SHA-512")
    val digest = messageDigest.digest(this.toByteArray())
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}


/**
 * Convert a given string to TitleCase
 *
 * Usage:
 *      val sentence = "This is an example sentence for string title case"
 *      sentence.convertToTitleCase()
 *          -> returns "This Is An Example Sentence For String Title Case"
 *
 * We can add an exclude list to eliminate the words we do not want to capitalise
 *
 * Usage:
 *      sentence.convertToTitleCase(listOf("for", "is", "an"))
 *          -> return "This is an Example Sentence for String Title Case"
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