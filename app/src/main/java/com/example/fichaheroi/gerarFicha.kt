package com.example.fichaheroi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class gerarFicha : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gerar_ficha)


        val nome = intent.getStringExtra("nome") ?: "---"
        val alinhamento = intent.getStringExtra("alinhamento") ?: "---"
        val poderes = intent.getStringExtra("poderes") ?: "---"

        val tvNome = findViewById<TextView>(R.id.tvNome)
        val tvAlinhamento = findViewById<TextView>(R.id.tvAlinhamento)
        val tvPoderes = findViewById<TextView>(R.id.tvPoderes)

        tvNome.text = "Nome: $nome"
        tvAlinhamento.text = "Alinhamento: $alinhamento"
        tvPoderes.text = "Poderes: $poderes"


        val mainLayout = findViewById<ConstraintLayout>(R.id.main)
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)


            insets
        }
    }
}