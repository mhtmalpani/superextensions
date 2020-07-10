package com.mhtmalpani.superextensions.custom

import com.google.gson.reflect.TypeToken

/**
 * Creates a new TypeToken for Collection based conversions
 *
 * Usage:
 *      val messageTypeToken = typeToken<List<Message>>()
 */
fun <T> typeToken(): TypeToken<T> = object : TypeToken<T>() {}