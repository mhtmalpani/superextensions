package com.mhtmalpani.superextensions.primitive

/**
 * @return false when the boolean is null, else the value of the boolean is returned
 *
 * Usage:
 *      val isLoggedIn: Boolean? = null
 *      isLoggedIn.orFalse()
 *          -> returns false
 */
fun Boolean?.orFalse(): Boolean {
    return this ?: false
}


/**
 * @return true when the boolean is null, else the value of the boolean is returned
 *
 * Usage:
 *      val isLoggedIn: Boolean? = null
 *      isLoggedIn.orTrue()
 *          -> returns true
 */
fun Boolean?.orTrue(): Boolean {
    return this ?: true
}


/**
 * @return false when the boolean is true
 * @return true when boolean is false
 *
 * Usage:
 *      val isLoggedIn: Boolean = true
 *      isLoggedIn.flip()
 *          -> returns false
 */
fun Boolean.flip(): Boolean {
    return !this
}