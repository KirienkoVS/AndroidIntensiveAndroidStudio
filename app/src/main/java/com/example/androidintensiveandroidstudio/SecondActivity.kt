package com.example.androidintensiveandroidstudio

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val cheeseButton = findViewById<Button>(R.id.cheese_button)
        val riceButton = findViewById<Button>(R.id.rice_button)
        val applesButton = findViewById<Button>(R.id.apples_button)
        val orangesButton = findViewById<Button>(R.id.oranges_button)
        val potatoButton = findViewById<Button>(R.id.potato_button)
        val breadButton = findViewById<Button>(R.id.bread_button)
        val juiceButton = findViewById<Button>(R.id.juice_button)
        val tomatoesButton = findViewById<Button>(R.id.tomatoes_button)
        val bananasButton = findViewById<Button>(R.id.bananas_button)
        val saladButton = findViewById<Button>(R.id.salad_button)

        val buttonsList = listOf<Button>(
            cheeseButton,
            riceButton,
            applesButton,
            orangesButton,
            potatoButton,
            breadButton,
            juiceButton,
            tomatoesButton,
            bananasButton,
            saladButton
        )

        for (button in buttonsList) {
            button.setOnClickListener {
                val item = button.text
                val replyIntent = Intent().putExtra(EXTRA_REPLY, item)
                setResult(RESULT_OK, replyIntent)
                finish()
            }
        }
    }
}