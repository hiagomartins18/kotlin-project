package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) { // Activity = Tela

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // utilizar o onCreate para dados estaticos desde o inicio do app

        // Variável criada para o Floating Button (Botão de Adicionar)
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)

        // Funcão de onClick dada ao botão
        // Utilizado o Intent para solicitar a ação do FormProduto
        fab.setOnClickListener {
            val intent = Intent(this, FormProdutoActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {

        // Utilizamos no onResume em componentes que serão atualizados durante o uso da activity

        super.onResume()

        // Aqui criamos a variável da nossa recyclerview, criamos a recyclerview como forma
        // de reutilizar os componentes. Nesse caso, cada item da Lista.
        // ActivityFormProduto
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)

        // Aqui buscamos os dados do DAO
        val dao = ProdutosDao()
        Log.i("MainActivity", "onCreate: ${dao.buscaTodos()}")

        //
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

        // deixar no onResume o que for atualizado

    }
}