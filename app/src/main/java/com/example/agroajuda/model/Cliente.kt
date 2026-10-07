package com.example.agroajuda.model

data class Cliente(
    val id: Int = 0,
    val nome: String,
    val telefone: String,
    val email: String,
    val localizacao: String
)