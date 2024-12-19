package com.example.orgs.dao

import com.example.orgs.model.Produtos

// Arquivo de armazenamento de Data da Lista de Produtos

class ProdutosDao {

    // Função de adcionar produtos

    fun adiciona(produtos: Produtos){
        produtoList.add(produtos)
    }

    // Função que retorna todos os items adcionados

    fun buscaTodos(): List<Produtos>{
        return produtoList.toList()
    }

    // Retorna objeto da classe

    companion object {
        private val produtoList = mutableListOf<Produtos>()
    }

}