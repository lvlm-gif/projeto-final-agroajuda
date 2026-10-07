package com.example.agroajuda.model

data class Profissional(
    val id: Int = 0,
    val nome: String,
    val tipo: String,
    val especialidade: String,
    val telefone: String,
    val descricao: String = ""
)