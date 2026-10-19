package com.example.agroajuda.data.repository

import com.example.agroajuda.data.local.dao.ProfissionalDao
import com.example.agroajuda.model.Profissional
import kotlinx.coroutines.flow.Flow

class ProfissionalRepository(private val profissionalDao: ProfissionalDao) {

    val allProfissionais: Flow<List<Profissional>> = profissionalDao.getAllProfissionais()

    fun getProfissionalById(id: Int): Flow<Profissional?> {
        return profissionalDao.getProfissionalById(id)
    }

    suspend fun insert(profissional: Profissional) {
        profissionalDao.insertProfissional(profissional)
    }
}
