package com.example.and102prework

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button = findViewById<Button>(R.id.helloButton)
        button.setOnClickListener {
            Log.v("Hello World", "Button Clicked!")
            Toast.makeText(this, "Hello to you too!", Toast.LENGTH_SHORT).show()
        }

        // Items
        val mePicture = findViewById<ImageView>(R.id.meImageView)
        val meText = findViewById<TextView>(R.id.introTextView)

        // State
        var showPrevWork = false

        val prevWorkButton = findViewById<Button>(R.id.showPrevWorkButton)
        val prevWorkPicture = findViewById<ImageView>(R.id.prevWorkImage)
        val prevWorkText = findViewById<TextView>(R.id.prevWorkTextView)
        prevWorkButton.setOnClickListener {
            showPrevWork = !showPrevWork

            if (showPrevWork) {
                prevWorkPicture.visibility = ImageView.VISIBLE
                prevWorkText.visibility = TextView.VISIBLE

                // Everything else invisible
                button.visibility = Button.INVISIBLE
                mePicture.visibility = ImageView.INVISIBLE
                meText.visibility = TextView.INVISIBLE
            } else {
                prevWorkPicture.visibility = ImageView.INVISIBLE
                prevWorkText.visibility = TextView.INVISIBLE

                // Everything else visible
                button.visibility = Button.VISIBLE
                mePicture.visibility = ImageView.VISIBLE
                meText.visibility = TextView.VISIBLE
            }
        }
    }
}