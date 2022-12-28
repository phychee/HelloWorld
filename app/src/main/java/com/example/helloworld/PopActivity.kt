package com.example.helloworld

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowInsets
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class PopActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop)

        // Hide the action bar.
        supportActionBar?.hide()

        // Action after pressing the close 'X' button.
        val closeButton = findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            // Close the pop-up window
            finish();
        }

        // Find screen dimensions without Action Bar
        var width: Int = 0
        var height: Int = 0
        // For new API versions
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics = this.windowManager.currentWindowMetrics
            val insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            height = windowMetrics.bounds.width() - insets.bottom - insets.top
            width = windowMetrics.bounds.height() - insets.left - insets.right
        }
        // For older versions
        else {
            val dm = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(dm)
            height = dm.heightPixels
            width = dm.widthPixels
        }

        // Determine size and place the pop-ip window
        window.setLayout((width*.35).toInt(), (height*.7).toInt())

        // Find the six random nom-duplicate lottery numbers
        val random = Random()
        val numbers = IntArray(6)
        var i = 0
        while (i < 6) {
            val number = random.nextInt(69) + 1
            if (number !in numbers) {
                numbers[i] = number
                i++
            }
        }
        numbers.sort()

        // Place lottery numbers on TextView
        val lotteryNumber= findViewById<TextView>(R.id.lottery_number)
        lotteryNumber.text = numbers.joinToString(separator = " ")
    }
}