package com.mhtmalpani.extensionsexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mhtmalpani.extensionsexample.model.LibraryModel
import com.mhtmalpani.superextensions.custom.assetToJsonObject
import com.mhtmalpani.superextensions.custom.readAssetAsString
import com.mhtmalpani.superextensions.view.bindStringArgument

class MainActivity : AppCompatActivity() {

    private val data by bindStringArgument(DATA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assetHelper()
    }

    private fun assetHelper() {
        val fileAsString = readAssetAsString("sample.json")
        println(fileAsString)

        val fileAsObject = assetToJsonObject("sample.json", LibraryModel::class.java)
        println("Name: ${fileAsObject.name}")
        println("Type: ${fileAsObject.type}")
    }

    companion object {
        private const val DATA = "data"
    }
}
