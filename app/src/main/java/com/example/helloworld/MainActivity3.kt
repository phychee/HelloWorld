package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Action after pressing the "no" button
        val noButton = findViewById<Button>(R.id.no)
        noButton.setOnClickListener {
            Log.v("Nah", "Button clicked!")
            // Display a toast message
            Toast.makeText(this, "Okay :(", Toast.LENGTH_SHORT).show()
        }

        // Action after pressing the "yes" button
        val yesButton = findViewById<Button>(R.id.yes)
        yesButton.setOnClickListener {
            Log.v("Sure", "Button clicked!")
            // Display a pop-up screen
            val intent = Intent(this, PopActivity::class.java)
            startActivity(intent)
        }
    }
}