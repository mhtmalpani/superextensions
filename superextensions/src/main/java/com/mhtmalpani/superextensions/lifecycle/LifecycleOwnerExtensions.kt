package com.mhtmalpani.superextensions.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

/**
 * Make a observable in a Lifecycle owner that will listen to changes in a live data
 *
 * Usage:
 *      Inside Activity:
 *
 *      observe(viewModel.someLiveData) {
 *          //Custom Logic to handle the live data
 *      }
 *
 *      OR
 *
 *      observe(viewModel.someLiveData, ::onLiveDataChanged)
 *
 *      private fun onLiveDataChanged(data: String) {
 *          //Custom Logic to handle the live data
 *          //Updated content is the value passed in the variable [data]
 *      }
 */
fun <T> LifecycleOwner.observe(liveData: LiveData<T>, body: (T) -> Unit = {}) {
    liveData.observe(this, Observer { it?.let { body(it) } })
}