package com.mhtmalpani.superextensions.view

import androidx.recyclerview.widget.RecyclerView

/**
 * Sets scroll listener to a recycler view
 *
 * Usage:
 *      your_recycler_view.setScrollListener {
 *          //Do some operation on scroll
 *      }
 */
fun RecyclerView.setScrollListener(onScrolled: () -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            onScrolled.invoke()
        }
    })
}


/**
 * Sets scroll listener to a recycler view
 *
 * Usage:
 *      your_recycler_view.setScrollListener { view ->
 *          //Do some operation on scroll
 *      }
 */
fun RecyclerView.setScrollListener(onScrolled: (recyclerView: RecyclerView) -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            onScrolled.invoke(recyclerView)
        }
    })
}


/**
 * Sets scroll listener to a recycler view
 *
 * Usage:
 *      your_recycler_view.setScrollListener { view, dx, dy ->
 *          //Do some operation on scroll
 *      }
 */
fun RecyclerView.setScrollListener(onScrolled: (recyclerView: RecyclerView, dx: Int, dy: Int) -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            onScrolled.invoke(recyclerView, dx, dy)
        }
    })
}


/**
 * Sets scroll state change listener to a recycler view
 *
 * Usage:
 *      your_recycler_view.setOnScrollStateChangeListener {
 *          //Do some operation on scroll state change
 *      }
 */
fun RecyclerView.setOnScrollStateChangeListener(onScrollStateChanged: () -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            onScrollStateChanged.invoke()
        }
    })
}


/**
 * Sets scroll state change listener to a recycler view
 *
 * Usage:
 *      your_recycler_view.setOnScrollStateChangeListener { view ->
 *          //Do some operation on scroll state change
 *      }
 */
fun RecyclerView.setOnScrollStateChangeListener(onScrollStateChanged: (recyclerView: RecyclerView) -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            onScrollStateChanged.invoke(recyclerView)
        }
    })
}

/**
 * Sets scroll state change listener to a recycler view
 *
 * Usage:
 *      your_recycler_view.setOnScrollStateChangeListener { view, newState ->
 *          //Do some operation on scroll state change
 *      }
 */
fun RecyclerView.setOnScrollStateChangeListener(onScrollStateChanged: (recyclerView: RecyclerView, newState: Int) -> Unit) {

    addOnScrollListener(object : RecyclerView.OnScrollListener() {

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            onScrollStateChanged.invoke(recyclerView, newState)
        }
    })
}