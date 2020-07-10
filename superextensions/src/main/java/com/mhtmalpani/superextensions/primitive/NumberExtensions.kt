package com.mhtmalpani.superextensions.primitive

/**
 * @return 0 when the Integer is null, else the value of the Integer is returned
 *
 * Usage:
 *      val data: Int? = null
 *      data.orZero()
 *          -> returns 0
 */
fun Int?.orZero(): Int = this ?: 0


/**
 * @return 0 when the Long is null, else the value of the Long is returned
 *
 * Usage:
 *      val data: Long? = null
 *      data.orZero()
 *          -> returns 0
 */
fun Long?.orZero(): Long = this ?: 0L


/**
 * @return 0 when the Float is null, else the value of the Float is returned
 *
 * Usage:
 *      val data: Float? = null
 *      data.orZero()
 *          -> returns 0
 */
fun Float?.orZero(): Float = this ?: 0F


/**
 * @return 0 when the Double is null, else the value of the Double is returned
 *
 * Usage:
 *      val data: Double? = null
 *      data.orZero()
 *          -> returns 0
 */
fun Double?.orZero(): Double = this ?: 0.0