package com.mhtmalpani.superextensions.custom

/**
 * Execute a block of code only when all the parameters passed are not null
 */
inline fun <T1 : Any, T2 : Any, R : Any> ifNotNull(
    p1: T1?,
    p2: T2?,
    block: (p1: T1, p2: T2) -> R?
): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}


/**
 * Execute a block of code only when all the parameters passed are not null
 */
inline fun <T1 : Any, T2 : Any, T3 : Any, R : Any> ifNotNull(
    p1: T1?,
    p2: T2?,
    p3: T3?,
    block: (p1: T1, p2: T2, p3: T3) -> R?
): R? {
    return if (p1 != null && p2 != null && p3 != null) block(p1, p2, p3) else null
}


/**
 * Execute the first lambda only when the parameter passed is null
 * else, execute the second lambda
 */
inline fun <T : Any, R : Any> T?.ifNullElseNonNull(
    whenNull: () -> R,
    whenNotNull: (T) -> R
): R {
    return this?.let { whenNotNull.invoke(it) } ?: whenNull.invoke()
}