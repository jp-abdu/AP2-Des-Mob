package com.example.appsuperherois

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.*

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val btnResult = findViewById<Button>(R.id.btnResult) // Botão para enviar o resultado
        btnResult.setOnClickListener {
            val nome = findViewById<EditText>(R.id.editNome).text.toString() // Nome do usuário
            val radioGroup = findViewById<RadioGroup>(R.id.radioGroup) // Grupo de botões de radio
            val checkedId = radioGroup.checkedRadioButtonId // ID do botão de radio selecionado
            val heroi = when (checkedId) { // Verifica qual botão de radio foi selecionado
                R.id.radioIronMan -> "Homem de Ferro"
                R.id.radioHulk -> "Hulk"
                R.id.radioSpiderMan -> "Homem-Aranha"
                else -> "Capitão América"
            }
            val intent = Intent(this, ResultadoActivity::class.java) // Intent para a próxima Activity
            intent.putExtra("NOME", nome) // Passa o nome do usuário
            intent.putExtra("HEROI", heroi) // Passa o super-herói escolhido
            startActivity(intent) // Inicia a próxima Activity
        }
    }
}