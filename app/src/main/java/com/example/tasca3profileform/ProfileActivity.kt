package com.example.tasca3profileform

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class ProfileActivity : AppCompatActivity() {
    lateinit var tvName: TextView
    lateinit var tvMail: TextView
    lateinit var tvDes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profileactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvName = findViewById(R.id.userNameView)
        tvMail = findViewById(R.id.userMailView)
        tvDes = findViewById(R.id.userDescriptionView)
        val tvImg = findViewById<ImageView>(R.id.imageContact)

        val name = intent.getStringExtra(CONSTANT_NAME) ?: ""
        val mail = intent.getStringExtra(CONSTANT_MAIL) ?: ""
        val description = intent.getStringExtra(CONSTANT_DESC) ?: ""
        val imageUrl = intent.getStringExtra(CONSTANT_IMG_URL) ?: ""

        tvName.text = name
        tvMail.text = mail
        tvDes.text = description

        // mostrar imagen
        /*Glide.with(this)
            .load(imageUrl)
            .into(tvImg)*/

        if (imageUrl.isNotEmpty()) {
            Glide.with(this)
                .load(imageUrl)
                .placeholder(android.R.drawable.stat_sys_download) // Muestra mientras carga
                .error(android.R.drawable.stat_notify_error)      // Muestra si la URL falla
                .into(tvImg)
        }
    }
}