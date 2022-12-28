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

        val noButton = findViewById<Button>(R.id.no)
        noButton.setOnClickListener {
            Log.v("Nah", "Button clicked!")
            Toast.makeText(this, "Ok:(", Toast.LENGTH_SHORT).show()
        }

        val yesButton = findViewById<Button>(R.id.yes)
        yesButton.setOnClickListener {
            Log.v("Sure", "Button clicked!")
            val intent = Intent(this, PopActivity::class.java)
            startActivity(intent)
        }
    }
}