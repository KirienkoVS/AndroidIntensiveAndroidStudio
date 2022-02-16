package com.example.androidintensiveandroidstudio

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Implicit intents"

        val openWebSiteButton = findViewById<Button>(R.id.open_website_button)
        val webSiteEditText = findViewById<TextView>(R.id.website_edittext)

        val openLocationButton = findViewById<Button>(R.id.open_location_button)
        val locationEditText = findViewById<TextView>(R.id.location_edittext)

        val shareTextButton = findViewById<Button>(R.id.share_text_button)
        val shareEditText = findViewById<TextView>(R.id.share_edittext)

        val takePictureButton = findViewById<Button>(R.id.take_picture_button)

        openWebSiteButton.setOnClickListener {
            val url = webSiteEditText.text.toString()
            val webPage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webPage)

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Application not found", Toast.LENGTH_SHORT).show()
            }
        }

        openLocationButton.setOnClickListener {
            val location = locationEditText.text.toString()
            val addressUri = Uri.parse("geo:0,0?q=$location")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)

            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(this, "Application not found", Toast.LENGTH_SHORT).show()
            }
        }

        shareTextButton.setOnClickListener {
            val text = shareEditText.text.toString()
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder(this)
                .setType(mimeType)
                .setChooserTitle(getString(R.string.chooser_title))
                .setText(text)
                .startChooser()
        }

        takePictureButton.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}