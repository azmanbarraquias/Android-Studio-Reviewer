package com.azman.testproject_kt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // enable back button on second page
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.title = "Second Activity"
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val secondActivityBtn: Button = findViewById(R.id.button2nd)
        secondActivityBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}