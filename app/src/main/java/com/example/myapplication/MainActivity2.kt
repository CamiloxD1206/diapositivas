package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recupera los datos del Intent
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")
        val gender = intent.getStringExtra("gender")

        // Muestra los datos en un TextView
        val userData = "Email: $email\nPassword: $password\nGender: $gender"
        binding.textViewUserData.text = userData

        binding.toggleButtonColor.setOnCheckedChangeListener { _, isChecked ->
            val backgroundColor = if (isChecked) {
                ContextCompat.getColor(this, android.R.color.white)
            } else {
                ContextCompat.getColor(this, android.R.color.black)
            }

            binding.root.setBackgroundColor(backgroundColor)

            // Cambia el color del texto en función del fondo
            val textColor = if (isChecked) {
                ContextCompat.getColor(this, android.R.color.black)
            } else {
                ContextCompat.getColor(this, android.R.color.white)
            }

            binding.textViewUserData.setTextColor(textColor)
        }
    }
}