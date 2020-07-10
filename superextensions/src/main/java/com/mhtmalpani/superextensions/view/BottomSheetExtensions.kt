package com.mhtmalpani.superextensions.view

import android.view.View
import com.google.android.material.bottomsheet.BottomSheetBehavior

/**
 * Add Bottom Sheet Callback for sheet slide
 *
 * Usage:
 *      your_bottom_sheet.onSlide {
 *          //Custom logic
 *      }
 */
fun <T : View> BottomSheetBehavior<T>.onSlide(action: () -> Unit) {

    addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            action.invoke()
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {

        }
    })
}


/**
 * Add Bottom Sheet Callback for sheet slide
 *
 * Usage:
 *      your_bottom_sheet.onSlide { view, slideOffset ->
 *          //Custom logic
 *      }
 */
fun <T : View> BottomSheetBehavior<T>.onSlide(action: (bottomSheet: View, slideOffset: Float) -> Unit) {

    addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            action.invoke(bottomSheet, slideOffset)
        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {

        }
    })
}


/**
 * Add Bottom Sheet Callback for sheet state change
 *
 * Usage:
 *      your_bottom_sheet.onStateChanged {
 *          //Custom logic
 *      }
 */
fun <T : View> BottomSheetBehavior<T>.onStateChanged(action: () -> Unit) {

    addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onSlide(bottomSheet: View, slideOffset: Float) {

        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            action.invoke()
        }
    })
}


/**
 * Add Bottom Sheet Callback for sheet state change
 *
 * Usage:
 *      your_bottom_sheet.onStateChanged { view, newState ->
 *          //Custom logic
 *      }
 */
fun <T : View> BottomSheetBehavior<T>.onStateChanged(action: (bottomSheet: View, newState: Int) -> Unit) {

    addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {

        override fun onSlide(bottomSheet: View, slideOffset: Float) {

        }

        override fun onStateChanged(bottomSheet: View, newState: Int) {
            action.invoke(bottomSheet, newState)
        }
    })
}