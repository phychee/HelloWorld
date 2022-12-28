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

        supportActionBar?.hide()

        val closeButton = findViewById<Button>(R.id.closeButton)
        closeButton.setOnClickListener {
            finish();
        }

        var width: Int = 0
        var height: Int = 0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val windowMetrics = this.windowManager.currentWindowMetrics
            val insets = windowMetrics.windowInsets
                .getInsetsIgnoringVisibility(WindowInsets.Type.systemBars())
            height = windowMetrics.bounds.width() - insets.bottom - insets.top
            width = windowMetrics.bounds.height() - insets.left - insets.right
        } else {
            val dm = DisplayMetrics()
            windowManager.defaultDisplay.getMetrics(dm)
            height = dm.heightPixels
            width = dm.widthPixels
        }

        window.setLayout((width*.35).toInt(), (height*.7).toInt())

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

        val lotteryNumber= findViewById<TextView>(R.id.lottery_number)
        lotteryNumber.text = numbers.joinToString(separator = " ")
    }
}