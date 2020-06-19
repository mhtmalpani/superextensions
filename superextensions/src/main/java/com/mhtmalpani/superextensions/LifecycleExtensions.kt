package com.mhtmalpani.superextensions

import androidx.lifecycle.Lifecycle

inline fun Lifecycle.whenAtLeastResumed(body: () -> Unit = {}) {
    if (this.currentState.isAtLeast(Lifecycle.State.RESUMED))
        body.invoke()
}