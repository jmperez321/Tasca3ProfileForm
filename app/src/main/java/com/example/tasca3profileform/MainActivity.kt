package com.example.tasca3profileform

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Constantes públicas compartidas con ProfileActivity
const val CONSTANT_NAME = "EXTRA_NAME"
const val CONSTANT_MAIL = "EXTRA_MAIL"
const val CONSTANT_DESC = "EXTRA_DESCRIPTION"
const val CONSTANT_IMG_URL = "EXTRA_IMG_URL"

class MainActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var inputName: EditText
    private lateinit var inputMail: EditText
    private lateinit var inputDescription: EditText
    private lateinit var inputLinkImg: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btn = findViewById(R.id.saveBTN)
        inputName = findViewById(R.id.inputName)
        inputMail = findViewById(R.id.inputMail)
        inputDescription = findViewById(R.id.inputDescripcion)
        inputLinkImg = findViewById(R.id.inputLinkImg)

        btn.setOnClickListener {
            val name = inputName.text.toString().trim()
            val mail = inputMail.text.toString().trim()
            val description = inputDescription.text.toString().trim()
            val imageUrl = inputLinkImg.text.toString()

            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra(CONSTANT_NAME, name)
                putExtra(CONSTANT_MAIL, mail)
                putExtra(CONSTANT_DESC, description)
                putExtra(CONSTANT_IMG_URL, imageUrl)
            }
            startActivity(intent)
        }
    }
}