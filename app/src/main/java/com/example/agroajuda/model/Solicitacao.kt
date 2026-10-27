package com.example.agroajuda.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "solicitacoes")
data class Solicitacao(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val profissionalId: Int,
    val status: String,
    val data: String
)
