package com.mhtmalpani.extensionsexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mhtmalpani.superextensions.view.bindArgument
import com.mhtmalpani.superextensions.view.fragmentTransaction
import com.mhtmalpani.superextensions.view.instanceOf


class MainFragment : Fragment() {

    private val data by bindArgument<String>(DATA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fragmentTransaction {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    companion object {
        private const val DATA = "data"

        fun newInstance(data: String) =
            instanceOf<MainFragment>(
                DATA to data
            )
    }
}