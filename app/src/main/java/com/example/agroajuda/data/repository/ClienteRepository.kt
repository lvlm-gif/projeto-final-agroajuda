package com.example.agroajuda.data.repository

import com.example.agroajuda.data.local.dao.ClienteDao
import com.example.agroajuda.model.Cliente
import kotlinx.coroutines.flow.Flow


class ClienteRepository(private val clienteDao: ClienteDao) {


    val allClientes: Flow<List<Cliente>> = clienteDao.getAllClientes()


    suspend fun insert(cliente: Cliente) {
        clienteDao.insert(cliente)
    }


    suspend fun delete(cliente: Cliente) {
        clienteDao.delete(cliente)
    }
}