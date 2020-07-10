package com.mhtmalpani.superextensions.view

import androidx.appcompat.widget.SearchView

/**
 * Sets the callback listener when the submit is clicked for a Search View
 *
 * Usage:
 *      your_search_view.setOnQueryTextSubmit { query ->
 *          //Your custom logic to handle the query
 *      }
 */
fun SearchView.setOnQueryTextSubmit(action: (query: String?) -> Unit) {

    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            action.invoke(query)
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return true
        }
    })
}


/**
 * Sets the callback listener when the text changes for a Search View
 *
 * Usage:
 *      your_search_view.setOnQueryTextChange { newText ->
 *          //Your custom logic to handle the new text
 *      }
 */
fun SearchView.setOnQueryTextChange(action: (newText: String?) -> Unit) {

    setOnQueryTextListener(object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            return true
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            action.invoke(newText)
            return true
        }
    })
}