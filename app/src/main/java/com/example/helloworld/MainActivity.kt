 package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

 class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Action after pressing the "Get Started" button
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            Log.v("Get Started", "Button clicked!")
            // Go to the next view
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
}