package com.mhtmalpani.superextensions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Gets a view model for a defined type
 *
 * Usage:
 *      ViewModelProviders.of(activity, MyViewModelFactory()).get()
 */
inline fun <reified T : ViewModel> ViewModelProvider.get() = get(T::class.java)