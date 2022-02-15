package com.example.androidintensiveandroidstudio

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addButton = findViewById<Button>(R.id.button_main)
        textView1 = findViewById(R.id.text_view_1)

        if (savedInstanceState != null) {
            textView1.apply {
                visibility = View.VISIBLE
                text = savedInstanceState.getString("item")
            }
        }

        val startActivityForResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val reply = result.data?.getStringExtra(EXTRA_REPLY)
                textView1.apply {
                    text = reply
                    visibility = View.VISIBLE
                }
            }
        }

        addButton.setOnClickListener {
            startActivityForResult.launch(Intent(this, SecondActivity::class.java))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (textView1.text.isNotBlank()) {
            outState.putString("item", textView1.text.toString())
        }
    }
}