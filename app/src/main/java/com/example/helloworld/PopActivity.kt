package com.example.helloworld

import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowInsets

class PopActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop)

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
    }
}