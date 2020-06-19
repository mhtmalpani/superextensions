package com.mhtmalpani.superextensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> ViewModelProvider.get() = get(T::class.java)