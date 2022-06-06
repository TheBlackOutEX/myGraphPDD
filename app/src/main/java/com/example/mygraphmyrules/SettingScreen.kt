package com.example.mygraphmyrules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class SettingScreen : AppCompatActivity() {



    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
        finish()
    }
}