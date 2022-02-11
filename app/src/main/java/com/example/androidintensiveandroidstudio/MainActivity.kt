package com.example.androidintensiveandroidstudio

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private var count: Int = 0
    private lateinit var countView: TextView
    private lateinit var toastButton: Button
    private lateinit var contButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countView = findViewById(R.id.show_count)
        toastButton = findViewById(R.id.button_toast)
        contButton = findViewById(R.id.button_count)

        toastButton.setOnClickListener {
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        }

        contButton.setOnClickListener {
            count++
            countView.text = count.toString()
        }
    }
}