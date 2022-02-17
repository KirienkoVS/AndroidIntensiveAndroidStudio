package com.example.androidintensiveandroidstudio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.iterator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.button_main)
        val constraintLayout = findViewById<ViewGroup>(R.id.constraint_layout)

        val textViewsList = mutableListOf<TextView>()
        for (view in constraintLayout) {
            if (view is TextView) {
                textViewsList.add(view)
            }
        }

        val startActivityForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val reply = result.data?.getStringExtra(EXTRA_REPLY)

                if (textViewsList.first().text.isBlank()) {
                    textViewsList.first().apply {
                        text = reply
                        visibility = View.VISIBLE
                    }
                } else {
                    val emptyTextView = textViewsList.first { it.text.isBlank() }
                    emptyTextView.apply {
                        text = reply
                        visibility = View.VISIBLE
                    }
                }
            }
        }

        addButton.setOnClickListener {
            val itemsList = textViewsList.filter { it.text.isNotBlank() }
            if (itemsList.size > 10) {
                recreate()
            }
            startActivityForResult.launch(Intent(this, SecondActivity::class.java))
        }
    }
}