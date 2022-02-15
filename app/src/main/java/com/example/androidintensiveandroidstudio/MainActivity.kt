package com.example.androidintensiveandroidstudio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
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

        val startActivityForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val reply = result.data?.getStringExtra(EXTRA_REPLY)
                replyHeadTextView.visibility = View.VISIBLE
                replyTextView.apply {
                    text = reply
                    visibility = View.VISIBLE
                }
            }
        }

        sendButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            val message = messageEditText.text.toString()
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivityForResult.launch(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        messageEditText.text.clear()
    }
}