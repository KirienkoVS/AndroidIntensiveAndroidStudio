package com.example.androidintensiveandroidstudio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var sendButton: Button
    private lateinit var messageEditText: EditText
    private lateinit var replyHeadTextView: TextView
    private lateinit var replyTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageEditText = findViewById(R.id.editText_main)
        sendButton = findViewById(R.id.button_main)
        replyHeadTextView = findViewById(R.id.text_header_reply)
        replyTextView = findViewById(R.id.text_message_reply)

        sendButton.setOnClickListener {
            Log.d(TAG, "Button clicked!")
            val intent = Intent(this, SecondActivity::class.java)
            val message = messageEditText.text.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivityForResult(intent, TEXT_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(EXTRA_REPLY)

                replyHeadTextView.visibility = View.VISIBLE

                replyTextView.apply {
                    text = reply
                    visibility = View.VISIBLE
                }
            }
        }
    }
}