package com.example.agroajuda.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.agroajuda.model.Solicitacao
import kotlinx.coroutines.flow.Flow

@Dao
interface SolicitacaoDao {

    @Query("SELECT * FROM solicitacoes ORDER BY data DESC")
    fun getAllSolicitacoes(): Flow<List<Solicitacao>>

    @Query("SELECT * FROM solicitacoes WHERE id = :id")
    fun getSolicitacaoById(id: Int): Flow<Solicitacao?>

    @Query("SELECT * FROM solicitacoes WHERE profissionalId = :profissionalId")
    fun getSolicitacoesByProfissional(profissionalId: Int): Flow<List<Solicitacao>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSolicitacao(solicitacao: Solicitacao)

    @Query("DELETE FROM solicitacoes WHERE id = :id")
    suspend fun deleteSolicitacaoById(id: Int)

    @Query("UPDATE solicitacoes SET status = :status WHERE id = :id")
    suspend fun updateStatus(id: Int, status: String)
}
