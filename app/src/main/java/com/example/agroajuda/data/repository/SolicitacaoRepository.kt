package com.example.agroajuda.data.repository

import com.example.agroajuda.data.local.dao.SolicitacaoDao
import com.example.agroajuda.model.Solicitacao
import kotlinx.coroutines.flow.Flow

/**
 * Repositório responsável por gerenciar as operações de dados das solicitações.
 * Segue o padrão estabelecido no ProfissionalRepository.
 */
class SolicitacaoRepository(private val solicitacaoDao: SolicitacaoDao) {

    /**
     * Fluxo que emite a lista de todas as solicitações cadastradas, ordenadas por data.
     */
    val allSolicitacoes: Flow<List<Solicitacao>> = solicitacaoDao.getAllSolicitacoes()

    /**
     * Retorna as solicitações vinculadas a um profissional específico.
     */
    fun getSolicitacoesByProfissional(profissionalId: Int): Flow<List<Solicitacao>> {
        return solicitacaoDao.getSolicitacoesByProfissional(profissionalId)
    }

    /**
     * Retorna uma solicitação específica baseada no seu ID.
     */
    fun getSolicitacaoById(id: Int): Flow<Solicitacao?> {
        return solicitacaoDao.getSolicitacaoById(id)
    }

    /**
     * Insere ou atualiza uma solicitação no banco de dados.
     */
    suspend fun insert(solicitacao: Solicitacao) {
        solicitacaoDao.insertSolicitacao(solicitacao)
    }

    /**
     * Remove uma solicitação do banco de dados pelo seu ID.
     */
    suspend fun deleteById(id: Int) {
        solicitacaoDao.deleteSolicitacaoById(id)
    }
}
