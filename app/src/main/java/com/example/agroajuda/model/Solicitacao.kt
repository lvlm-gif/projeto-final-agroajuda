package com.example.agroajuda.model

data class Solicitacao(
    val id: Int = 0,
    val profissionalId: Int,
    val status: String,
    val data: String
)