package com.mhtmalpani.superextensions.view

import android.os.Parcelable
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


/**
 * Create a new instance of a Fragment smoothly.
 * This should be generally used as a new instance creation from within the fragment.
 *
 * Prefer to use a companion object and invoke this:
 *
 * Usage:
 *      companion object {
 *          fun getIntent(): MyFragment = instanceOf<MyFragment>()
 *      }
 *
 * We can add custom data as arguments as a Pair.
 * Usage:
 *      companion object {
 *          private const val USERNAME = "username"
 *          private const val AGE = "age"
 *
 *          fun getIntent(username: String, age: Int): MyFragment = instanceOf<MyFragment>(
 *              USERNAME to username,
 *              AGE to age
 *          )
 *      }
 */
inline fun <reified T : Fragment> instanceOf(vararg params: Pair<String, Any?>): T =
    T::class.java.newInstance().apply {
        arguments = bundleOf(*params)
    }


///////////////////////////////////////////////////////////////////////////////////////////////////
//                                      Bind Arguments
///////////////////////////////////////////////////////////////////////////////////////////////////

/**
 * A simple Delegate to bind an argument passed to a Fragment
 *
 * @param key: The name of the argument passed
 *
 * Usage:
 *      private val username by bindArgument<String>(USERNAME)
 */
inline fun <reified T : Any> Fragment.bindArgument(key: String): Lazy<T> = lazy {
    arguments?.get(key) as? T ?: throw IllegalArgumentException("Argument not passed for key: $key")
}


/**
 * A simple Delegate to bind a Serializable argument passed to a Fragment
 *
 * @param key: The name of the argument passed
 *
 * Usage:
 *      private val username by bindSerializableArgument<String>(USERNAME)
 */
inline fun <reified T : Any> Fragment.bindSerializableArgument(key: String): Lazy<T> = lazy {
    arguments?.getSerializable(key) as? T
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}


/**
 * A simple Delegate to bind a Parcelable argument passed to a Fragment
 *
 * @param key: The name of the argument passed
 *
 * Usage:
 *      private val userdata by bindParcelableArgument<String>(USERDATA)
 */
inline fun <reified T : Parcelable> Fragment.bindParcelableArgument(key: String): Lazy<T> = lazy {
    arguments?.getParcelable(key) as? T
        ?: throw IllegalArgumentException("Argument not passed for key: $key")
}


///////////////////////////////////////////////////////////////////////////////////////////////////
//                                      FragmentManager
///////////////////////////////////////////////////////////////////////////////////////////////////


/**
 * Creates a fragment transaction smoothly
 *
 * Usage:
 *      supportFragmentManager.transaction {
 *          replace(R.id.fragment_container, YourFragment(), YourFragment.TAG)
 *      }
 */
fun FragmentManager.transaction(body: FragmentTransaction.() -> Unit) {
    beginTransaction().also {
        body(it)
    }.commit()
}