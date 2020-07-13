package com.mhtmalpani.superextensions.custom

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

/**
 * Creates a vibration
 *
 * Note: Required Vibrator PERMISSION in Manifest
 *
 * @param milliseconds duration of vibration
 * @param amplitude the intensity of vibration
 */
@RequiresApi(Build.VERSION_CODES.O)
fun Context.vibrate(milliseconds: Long = 100, amplitude: Int = VibrationEffect.DEFAULT_AMPLITUDE) {
    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
    vibration(vibrator, milliseconds, amplitude)
}


/**
 * Creates a vibration
 *
 * Note: Required Vibrator PERMISSION in Manifest
 *
 * @param milliseconds duration of vibration
 * @param amplitude the intensity of vibration
 */
@RequiresApi(Build.VERSION_CODES.O)
fun Fragment.vibrate(milliseconds: Long = 100, amplitude: Int = VibrationEffect.DEFAULT_AMPLITUDE) {
    val vibrator = requireActivity().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
    vibration(vibrator, milliseconds, amplitude)
}


/**
 * Creates a vibration
 *
 * Note: Required Vibrator PERMISSION in Manifest
 *
 * @param milliseconds duration of vibration
 */
@SuppressLint("MissingPermission")
fun Context.vibrate(milliseconds: Long = 100) {
    val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
    vibrator?.vibrate(milliseconds)
}


/**
 * Creates a vibration
 *
 * Note: Required Vibrator PERMISSION in Manifest
 *
 * @param milliseconds duration of vibration
 */
@SuppressLint("MissingPermission")
fun Fragment.vibrate(milliseconds: Long = 100) {
    val vibrator = requireActivity().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
    vibrator?.vibrate(milliseconds)
}


@SuppressLint("MissingPermission")
private fun vibration(vibrator: Vibrator?, milliseconds: Long, amplitude: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        vibrator?.vibrate(
            VibrationEffect.createOneShot(milliseconds, amplitude)
        )
    } else {
        vibrator?.vibrate(milliseconds)
    }
}