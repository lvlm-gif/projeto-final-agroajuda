package com.example.agroajuda.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.agroajuda.data.repository.ProfissionalRepository
import com.example.agroajuda.model.Profissional
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfissionalViewModel(private val repository: ProfissionalRepository) : ViewModel() {

    val allProfissionais: StateFlow<List<Profissional>> = repository.allProfissionais
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun getProfissionalById(id: Int): Flow<Profissional?> {
        return repository.getProfissionalById(id)
    }

    fun insert(profissional: Profissional, onComplete: () -> Unit) {
        viewModelScope.launch {
            repository.insert(profissional)
            onComplete()
        }
    }
}

class ProfissionalViewModelFactory(private val repository: ProfissionalRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfissionalViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ProfissionalViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
