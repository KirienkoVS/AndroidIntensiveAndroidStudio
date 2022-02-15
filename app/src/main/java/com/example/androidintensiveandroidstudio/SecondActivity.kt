package com.example.androidintensiveandroidstudio

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val count = findViewById<TextView>(R.id.count)
        count.text = intent.getStringExtra(EXTRA_MESSAGE)
    }
}