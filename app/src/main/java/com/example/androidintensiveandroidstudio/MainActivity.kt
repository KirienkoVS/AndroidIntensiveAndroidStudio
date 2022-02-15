package com.example.androidintensiveandroidstudio

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Implicit intents"

        val openWebSiteButton = findViewById<Button>(R.id.open_website_button)
        val webSiteEditText = findViewById<TextView>(R.id.website_edittext)

        val openLocationButton = findViewById<Button>(R.id.open_location_button)
        val locationEditText = findViewById<TextView>(R.id.location_edittext)

        openWebSiteButton.setOnClickListener {
            val url = webSiteEditText.text.toString()
            val webPage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webPage)

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Log.e(TAG, "Application not found")
            }
        }

        openLocationButton.setOnClickListener {
            val location = locationEditText.text.toString()
            val addressUri = Uri.parse("geo:0,0?q=$location")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Log.e(TAG, "Application not found")
            }
        }
    }
}