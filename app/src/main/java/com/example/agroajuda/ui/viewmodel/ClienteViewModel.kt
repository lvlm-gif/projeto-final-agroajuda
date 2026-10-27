package com.example.agroajuda.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.agroajuda.data.repository.ClienteRepository
import com.example.agroajuda.model.Cliente
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ClienteViewModel(private val repository: ClienteRepository) : ViewModel() {


    val allClientes: StateFlow<List<Cliente>> = repository.allClientes
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    fun insert(cliente: Cliente) {
        viewModelScope.launch {
            repository.insert(cliente)
        }
    }


    fun delete(cliente: Cliente) {
        viewModelScope.launch {
            repository.delete(cliente)
        }
    }
}