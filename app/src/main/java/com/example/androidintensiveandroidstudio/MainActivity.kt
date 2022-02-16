package com.example.androidintensiveandroidstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "2.1 Activities and intents: coding challenge"

        val buttonsList = listOf<Button>(
            findViewById(R.id.button_one),
            findViewById(R.id.button_two),
            findViewById(R.id.button_three)
        )

        buttonsList.forEach { button ->
            button.setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                val message = button.text.toString()
                intent.putExtra(EXTRA_MESSAGE, message)
                startActivity(intent)
            }
        }
    }
}