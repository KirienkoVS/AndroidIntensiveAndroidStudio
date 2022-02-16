package com.example.androidintensiveandroidstudio

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countView = findViewById<TextView>(R.id.show_count)
        val toastButton = findViewById<Button>(R.id.button_toast)
        val countButton = findViewById<Button>(R.id.button_count)
        val zeroButton = findViewById<Button>(R.id.button_zero)

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(TAG)
            countView.text = savedInstanceState.getInt(TAG).toString()
        }

        toastButton.setOnClickListener {
            Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
        }

        countButton.setOnClickListener {
            count++
            countView.text = count.toString()
            zeroButton.setBackgroundColor(resources.getColor(R.color.red))

            if (count % 2 == 0) {
                it.setBackgroundColor(resources.getColor(R.color.teal_200))
            } else {
                it.setBackgroundColor(resources.getColor(R.color.purple_500))
            }
        }

        zeroButton.setOnClickListener {
            countView.text = "0"
            count = 0
            it.setBackgroundColor(resources.getColor(R.color.purple_500))
            countButton.setBackgroundColor(resources.getColor(R.color.purple_500))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(TAG, count)
    }
}