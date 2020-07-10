package com.mhtmalpani.superextensions.custom

/**
 * Execute a block of code only when all the parameters passed are not null
 *
 * @param p1 First variable to check for non-null
 * @param p2 Second variable to check for non-null
 * @param block Action to execute if both [p1] and [p2] are not null
 *
 * Usage:
 *      ifNotNull(username, password) { name, pass ->
 *          //Your custom logic to execute when the params are not null
 *          //name and pass to be used here
 *      }
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
 *
 * @param p1 First variable to check for non-null
 * @param p2 Second variable to check for non-null
 * @param p3 Third variable to check for non-null
 * @param block Action to execute if all [p1], [p2] and [p3] are not null
 *
 * Usage:
 *      ifNotNull(username, password, dateOfBirth) { name, pass, dob ->
 *          //Your custom logic to execute when the params are not null
 *          //name, pass and dob to be used here
 *      }
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
 *
 * @param whenNull Action to execute when the given object is null
 * @param whenNotNull Action to execute when the given object is not null
 *
 * Usage:
 *      username.ifNullElseNonNull(
 *          { println("Username is Null") },
 *          { println("Username is Not-Null") },
 *      )
 */
inline fun <T : Any, R : Any> T?.ifNullElseNonNull(
    whenNull: () -> R,
    whenNotNull: (T) -> R
): R {
    return this?.let { whenNotNull.invoke(it) } ?: whenNull.invoke()
}