package com.example.androidintensiveandroidstudio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var replyButton: Button
    private lateinit var messageEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        messageEditText = findViewById(R.id.editText_second)
        replyButton = findViewById(R.id.button_second)

        val intent = intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.text_message)
        textView.text = message

        replyButton.setOnClickListener {
            val reply = messageEditText.text.toString()
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY, reply)
            setResult(RESULT_OK, replyIntent)
            Log.d(SECOND_ACTIVITY, "End SecondActivity")
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(SECOND_ACTIVITY, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(SECOND_ACTIVITY, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(SECOND_ACTIVITY, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(SECOND_ACTIVITY, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(SECOND_ACTIVITY, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(SECOND_ACTIVITY, "onDestroy")
    }
}