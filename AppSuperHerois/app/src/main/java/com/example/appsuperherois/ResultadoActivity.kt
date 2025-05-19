package com.example.appsuperherois

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView

class ResultadoActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val nome = intent.getStringExtra("NOME") // Nome do usuário
        val heroi = intent.getStringExtra("HEROI") // Super-herói escolhido

        val txtResult = findViewById<TextView>(R.id.txtResult) // TextView para exibir o resultado
        val imgHero = findViewById<ImageView>(R.id.imgHero) // ImageView para exibir a imagem do super-herói
        txtResult.text = "$nome, você se parece com o $heroi!" // Exibindo o resultado na TextView

        // Definindo a imagem do super-herói com base na escolha
        when (heroi) {
            "Homem de Ferro" -> imgHero.setImageResource(R.drawable.ironman)
            "Hulk" -> imgHero.setImageResource(R.drawable.hulk)
            "Homem-Aranha" -> imgHero.setImageResource(R.drawable.spiderman)
            else -> imgHero.setImageResource(R.drawable.captainamerica)
        }

        //Intent Explícita (Para refazer o quiz)
        val btnVoltar = findViewById<Button>(R.id.btnVoltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Intent Implícita (Para compartilhar o resultado)
        val btncompartilhar = findViewById<Button>(R.id.btnShare)
        btncompartilhar.setOnClickListener {
            val shareIntent = Intent().apply { //Criando a Intent para compartilhar o resultado
                action = Intent.ACTION_SEND // Ação de compartilhamento
                putExtra(Intent.EXTRA_TEXT, "Eu sou parecido com o $heroi!") // Mensagem a ser compartilhada
                type = "text/plain" // Tipo de dado a ser compartilhado
            }
            startActivity(Intent.createChooser(shareIntent, "Compartilhar via"))
        }
    }
}