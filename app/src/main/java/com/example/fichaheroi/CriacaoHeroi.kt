package com.example.fichaheroi

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.*
import androidx.appcompat.app.AlertDialog
import android.content.Intent

class CriacaoHeroi : AppCompatActivity() {

    private lateinit var rgTipoHeroi: RadioGroup
    private lateinit var cbTelepatia: CheckBox
    private lateinit var cbRajada: CheckBox
    private lateinit var cbVoo: CheckBox
    private lateinit var cbSuperforca: CheckBox
    private lateinit var btnCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_criacao_heroi)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            return@setOnApplyWindowInsetsListener insets
        }

        rgTipoHeroi = findViewById(R.id.rg_tipo_heroi)
        cbTelepatia = findViewById(R.id.cb_telepatia)
        cbRajada = findViewById(R.id.cb_rajada)
        cbVoo = findViewById(R.id.cb_voo)
        cbSuperforca = findViewById(R.id.cb_superforca)
        btnCadastrar = findViewById(R.id.btn_cadastrar)

        btnCadastrar.setOnClickListener {
            gerarFicha()
        }
    }

    private fun gerarFicha() {

        val nome = intent.getStringExtra("codinome") ?: "Herói sem nome"


        val alinhamentoSelecionadoId = rgTipoHeroi.checkedRadioButtonId
        if (alinhamentoSelecionadoId == -1) {
            Toast.makeText(this, "Selecione um tipo de herói", Toast.LENGTH_SHORT).show()
            return
        }
        val rbSelecionado = findViewById<RadioButton>(alinhamentoSelecionadoId)
        val alinhamento = rbSelecionado.text.toString()


        val poderes = mutableListOf<String>()
        if (cbTelepatia.isChecked) poderes.add(cbTelepatia.text.toString())
        if (cbRajada.isChecked) poderes.add(cbRajada.text.toString())
        if (cbVoo.isChecked) poderes.add(cbVoo.text.toString())
        if (cbSuperforca.isChecked) poderes.add(cbSuperforca.text.toString())


        val poderesString = if (poderes.isEmpty()) {
            "Nenhum selecionado"
        } else {
            poderes.joinToString(", ")
        }


        val intent = Intent(this, gerarFicha::class.java).apply {
            putExtra("nome", nome)
            putExtra("alinhamento", alinhamento)
            putExtra("poderes", poderesString)
        }
        startActivity(intent)
    }
}