package com.example.androidintensiveandroidstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(TAG)
            countView.text = savedInstanceState.getInt(TAG).toString()
        }

        toastButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val message = count.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivity(intent)
        }

        contButton.setOnClickListener {
            count++
            countView.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TAG, count)
    }
}