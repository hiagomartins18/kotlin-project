package com.example.orgs.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.model.Produtos
import java.math.BigDecimal


// Tela de Formulário
// AppCompatActivity(R.layout.activity_form_produto) = Informar que o layout que está sendo utilizado é o do "activity_form_produto"
class FormProdutoActivity : AppCompatActivity(R.layout.activity_form_produto) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Variável do Botão de Salvar
        val botaoSalvar = findViewById<Button>(R.id.botaoSalvar)

        // Ação que o botão salvar faz ao ser clicado
        botaoSalvar.setOnClickListener {

            // Variável do Input e Variável para pegar o dados do input de nome
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString();

            // Variável do Input e Variável para pegar o dados do input de descricao
            val campoDescricao = findViewById<EditText>(R.id.descricaoEdit)
            val descricao = campoDescricao.text.toString();

            // Variável do Input e Variável para pegar o dados do input de valor
            val campoValor = findViewById<EditText>(R.id.valorEdit)
            val valorEmTexto = campoValor.text.toString();

            // Condicional caso o valor valor não seja preenchido ou tenha espaço em branco
            val valor = if (valorEmTexto.isBlank()) {
                BigDecimal.ZERO
            } else {
                BigDecimal(valorEmTexto)
            }

            // Aderindo as variáveis do produto aos valores do input
            val produtoCriado = Produtos(
                nome = nome,
                descricao = descricao,
                valor = valor
            )

            Log.i("FormProdutoActivity", "onCreate $produtoCriado")

            // Utilizando os métodos da dao ProdutosDao
            val dao = ProdutosDao()
            dao.adiciona(produtoCriado)

            Log.i("FormProdutoActivity", "onCreate ${dao.buscaTodos()}")

            // Finalizando a activity, fazendo retornar a MainActivity
            finish()
        }

    }

}