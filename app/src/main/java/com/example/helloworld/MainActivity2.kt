package com.example.helloworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val nextButton = findViewById<Button>(R.id.nextButton)
        nextButton.setOnClickListener {
            Log.v("Next", "Button clicked!")
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}