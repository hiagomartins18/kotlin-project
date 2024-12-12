package com.example.orgs.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.R
import com.example.orgs.model.Produtos
import java.math.BigDecimal

class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.botaoSalvar)
        botaoSalvar.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            var nome = campoNome.text.toString();

            val campoDescricao = findViewById<EditText>(R.id.descricaoEdit)
            val descricao = campoDescricao.text.toString();

            val campoValor = findViewById<EditText>(R.id.valorEdit)
            val valorEmTexto = campoValor.text.toString();

            val valor = if (valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            val produtoCriado = Produtos(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            Log.i("FormProdutoActivity", "onCreate $produtoCriado")
        }

    }

}