package com.example.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class bundleDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bundle_data)

        val intent = intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        val nameData = findViewById<TextView>(R.id.nameData)
        val emailData = findViewById<TextView>(R.id.emailData)
        val passwordData = findViewById<TextView>(R.id.passwordData)

        nameData.text = name
        emailData.text = email
        passwordData.text = password

    }
}