package com.mhtmalpani.superextensions.view

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.setScrollListener(onScrolled: () -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            onScrolled.invoke()
        }
    })
}

fun RecyclerView.setScrollListeners(onScrolled: (dx: Int, dy: Int) -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            onScrolled.invoke(dx, dy)
        }
    })
}

fun RecyclerView.setOnScrollStateChangeListeners(onScrollStateChanged: () -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            onScrollStateChanged.invoke()
        }
    })
}

fun RecyclerView.setOnScrollStateChangeListeners(onScrollStateChanged: (newState: Int) -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            onScrollStateChanged.invoke(newState)
        }
    })
}