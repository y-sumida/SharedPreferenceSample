package com.example.sharedpreferencesample

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("file_name", Context.MODE_PRIVATE)

        val storedText = pref.getString("key", getString(R.string.notStored))

        editText.setText(storedText)

        store.setOnClickListener {
            val inputText = editText.text.toString()
            pref.edit().putString("key", inputText).apply()
        }
    }
}
