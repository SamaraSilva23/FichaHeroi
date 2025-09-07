package com.example.fichaheroi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.content.Intent
import com.example.fichaheroi.CriacaoHeroi

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nome = findViewById<TextView>(R.id.nome)
        val button = findViewById<Button>(R.id.continueButton)

        val banco = getSharedPreferences("Hero", MODE_PRIVATE)
        val salvarnome = banco.getString("heroinome", null)

        salvarnome?.let{
            nome.text = it
        }

        button.setOnClickListener {
            val novonome = nome.text.toString()
            banco.edit().putString("heroinome",novonome).apply()

            val intent = Intent(this, CriacaoHeroi ::class.java)
            intent.putExtra("codinome",novonome)
            startActivity(intent)


        }
    }
}
