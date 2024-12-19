package com.example.orgs.model

import java.math.BigDecimal

// Data class que retorna os parametros necessários de um item da lista.

data class Produtos(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal
)
