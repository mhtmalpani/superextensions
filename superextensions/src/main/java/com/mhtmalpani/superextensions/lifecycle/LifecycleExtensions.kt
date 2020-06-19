package com.mhtmalpani.superextensions.lifecycle

import androidx.lifecycle.Lifecycle

inline fun Lifecycle.whenAtLeastCreated(body: () -> Unit = {}) {
    if (this.currentState.isAtLeast(Lifecycle.State.CREATED))
        body.invoke()
}

inline fun Lifecycle.whenAtLeastStarted(body: () -> Unit = {}) {
    if (this.currentState.isAtLeast(Lifecycle.State.STARTED))
        body.invoke()
}

inline fun Lifecycle.whenAtLeastResumed(body: () -> Unit = {}) {
    if (this.currentState.isAtLeast(Lifecycle.State.RESUMED))
        body.invoke()
}
