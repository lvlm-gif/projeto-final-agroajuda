package com.example.agroajuda.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profissionais")
data class Profissional(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val tipo: String,
    val especialidade: String,
    val telefone: String,
    val descricao: String = ""
)
