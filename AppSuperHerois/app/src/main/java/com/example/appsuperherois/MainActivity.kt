package com.example.appsuperherois

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btnStart) // Botão para iniciar o quiz
        btnStart.setOnClickListener { // Configurando o clique do botão
            val intent = Intent(this, QuizActivity::class.java) // Intent para iniciar a QuizActivity
            startActivity(intent) // Inicia a QuizActivity
        }
    }
}