package com.example.androidintensiveandroidstudio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sendButton: Button
    private lateinit var messageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageEditText = findViewById(R.id.editText_main)
        sendButton = findViewById<Button>(R.id.button_main)
        sendButton.setOnClickListener {
            Log.d(TAG, "Button clicked!")
            val intent = Intent(this, SecondActivity::class.java)
            val message = messageEditText.text.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivity(intent)
        }
    }
}