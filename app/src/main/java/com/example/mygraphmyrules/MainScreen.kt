package com.example.mygraphmyrules

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val img1 = findViewById<ImageButton>(R.id.settings) as ImageButton

        img1.setOnClickListener {
            val press = Intent(this, SettingScreen::class.java)
            startActivity(press)
            finish()
        }

        supportActionBar?.hide()

        val listView = findViewById<ListView>(R.id.list) as ListView

        val tickets = arrayOf(
            "Билет №1","Билет №2","Билет №3",
            "Билет №4", "Билет №5", "Билет №6",
            "Билет №7", "Билет №8", "Билет №9"
        )

        val adp : ArrayAdapter<String> = ArrayAdapter(
            this@MainScreen,android.R.layout.simple_list_item_1,tickets
        )

        listView.adapter = adp

        listView.setOnItemClickListener { _, _, number, id ->
            val startEx = Intent(this, QuestionScreen::class.java)
            startEx.putExtra("id", id)
            startEx.putExtra("number", number + 1)
            startActivity(startEx)
            finish()
        }
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
        finish()
    }
}