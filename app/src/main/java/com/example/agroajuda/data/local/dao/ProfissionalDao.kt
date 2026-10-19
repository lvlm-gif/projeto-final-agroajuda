package com.example.agroajuda.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.agroajuda.model.Profissional
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfissionalDao {

    @Query("SELECT * FROM profissionais")
    fun getAllProfissionais(): Flow<List<Profissional>>

    @Query("SELECT * FROM profissionais WHERE id = :id")
    fun getProfissionalById(id: Int): Flow<Profissional?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProfissional(profissional: Profissional)
}
