package com.example.orgs

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : Activity() { // Activity = Tela

    override fun onCreate(savedInstanceState: Bundle?) { // Criação de Views
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Para adicionar uma view da pastas res/layout.

        // Evitar utilizar valores em Layout, conteudo da Activity sempre no código fonte.
        // Binding com layout.

        val nome: TextView = findViewById<TextView>(R.id.TituloDesc)
        nome.text = "Cesta de Frutas"

        val descricao: TextView = findViewById<TextView>(R.id.descricao)
        descricao.text = "Manga, Uva e Morango"

        val preco: TextView = findViewById<TextView>(R.id.valor)
        preco.text = "19.90"

    }

}