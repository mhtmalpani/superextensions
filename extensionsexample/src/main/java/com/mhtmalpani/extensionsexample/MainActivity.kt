package com.mhtmalpani.extensionsexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mhtmalpani.extensionsexample.model.LibraryModel
import com.mhtmalpani.superextensions.custom.assetToJsonObject
import com.mhtmalpani.superextensions.custom.readAssetAsString
import com.mhtmalpani.superextensions.primitive.convertToTitleCase
import com.mhtmalpani.superextensions.primitive.encodeToUTF8
import com.mhtmalpani.superextensions.primitive.sha256
import com.mhtmalpani.superextensions.primitive.sha512
import com.mhtmalpani.superextensions.view.bindStringArgument

class MainActivity : AppCompatActivity() {

    private val data by bindStringArgument(DATA)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assetHelper()
        stringExtensions()
    }

    private fun assetHelper() {
        val fileAsString = readAssetAsString("sample.json")
        println(fileAsString)

        val fileAsObject = assetToJsonObject("sample.json", LibraryModel::class.java)
        println("Name: ${fileAsObject.name}")
        println("Type: ${fileAsObject.type}")
    }

    private fun stringExtensions() {
        val sha = "Hello".sha512()
        println("Hash of Hello: $sha")

        val url = "https://www.example.com?ref=www.github.com&hash=123456789"
        println("UTF-8 encoded: ${url.encodeToUTF8()}")

        val sentence = "This is an example sentence for string title case"
        println(sentence.convertToTitleCase())
        println(sentence.convertToTitleCase(listOf("for", "is", "an")))
    }

    companion object {
        private const val DATA = "data"
    }
}
