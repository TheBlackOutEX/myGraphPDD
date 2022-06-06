package com.example.mygraphmyrules

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import android.content.ClipData.newIntent




@Suppress("DEPRECATION")
@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.splash_screen)
        Handler().postDelayed(Runnable {
            val i = Intent(this, MainScreen::class.java)
            startActivity(i)
            finish()
        }, 2000)
    }

    private fun mainScreen() {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
        finish()
    }

    }