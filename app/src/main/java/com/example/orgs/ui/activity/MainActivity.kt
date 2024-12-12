package com.example.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.model.Produtos
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity(R.layout.activity_main) { // Activity = Tela

    override fun onCreate(savedInstanceState: Bundle?) { // Criação de Views
        super.onCreate(savedInstanceState)

        // Evitar utilizar valores em Layout, conteudo da Activity sempre no código fonte.
        // Binding com layout.

//        val nome: TextView = findViewById<TextView>(R.id.TituloDesc)
//        nome.text = "Cesta de Frutas"
//
//        val descricao: TextView = findViewById<TextView>(R.id.descricao)
//        descricao.text = "Manga, Uva e Morango"
//
//        val preco: TextView = findViewById<TextView>(R.id.valor)
//        preco.text = "19.90"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produtos(nome = "Teste1", descricao = "test desc", valor = BigDecimal("19.99")),
            Produtos(nome = "Teste2", descricao = "test desc", valor = BigDecimal("21.99"))
        ))
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

}