package com.example.androidintensiveandroidstudio

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Implicit intents"

        val storeButton = findViewById<Button>(R.id.store_button)
        val locationEditText = findViewById<TextView>(R.id.location_edit_text)
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

        storeButton.setOnClickListener {
            val location = locationEditText.text.toString()
            val addressUri = Uri.parse("geo:0,0?q=$location")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Application not found", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (textView1.text.isNotBlank()) {
            outState.putString("item", textView1.text.toString())
        }
    }
}