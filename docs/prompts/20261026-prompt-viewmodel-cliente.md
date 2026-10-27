# Prompt: Criação do ClienteViewModel

## Objetivo
Reconstrução do prompt utilizado para implementar o ViewModel da funcionalidade de Clientes, seguindo a arquitetura MVVM.

## Conteúdo do Prompt (Reconstruído)
Crie a classe `ClienteViewModel` no pacote `com.example.agroajuda.ui.viewmodel`. Esta classe deve gerenciar o estado da UI para a funcionalidade de Clientes.

**Requisitos:**
- Receber `ClienteRepository` no construtor.
- Expor a lista de clientes usando um `StateFlow<List<Cliente>>` chamado `allClientes`, utilizando o operador `stateIn` para converter o Flow do repositório.
- Implementar as funções `fun insert(cliente: Cliente)` e `fun delete(cliente: Cliente)` utilizando o `viewModelScope.launch` para executar as operações de forma assíncrona.
- O ViewModel deve ser independente da camada de UI.
