# Output - Implementação do SolicitacaoViewModel

Data: 2026-10-22

## Alterações Realizadas

### 1. Novo ViewModel (`app/src/main/java/com/example/agroajuda/ui/viewmodel/SolicitacaoViewModel.kt`)
*   Criada a classe `SolicitacaoViewModel`.
*   Implementada a injeção de `SolicitacaoRepository` via construtor.
*   **Propriedades e Métodos:**
    *   `allSolicitacoes`: `StateFlow<List<Solicitacao>>` que observa o repositório e mantém o estado para a UI Compose, iniciando com uma lista vazia.
    *   `getSolicitacoesByProfissional(id)`: Encaminha a consulta filtrada.
    *   `getSolicitacaoById(id)`: Encaminha a consulta por ID único.
    *   `insert(solicitacao, onComplete)`: Lança uma coroutine no `viewModelScope` para salvar os dados e executa um callback opcional ao finalizar.
    *   `delete(id, onComplete)`: Lança uma coroutine no `viewModelScope` para remover a solicitação.
*   **Factory:**
    *   Criada a classe `SolicitacaoViewModelFactory` para permitir a criação do ViewModel com parâmetros (Repositório) através do `ViewModelProvider`.

## Responsabilidades
*   **Gerenciamento de Estado:** Converte os `Flows` de dados em estados observáveis (`StateFlow`) que o Jetpack Compose pode reagir eficientemente.
*   **Escopo de Execução:** Garante que as operações de banco de dados iniciadas pela UI sejam canceladas se o ViewModel for destruído, evitando vazamentos de memória e crashes.

## Verificações
*   Os métodos chamados no repositório (`allSolicitacoes`, `insert`, `deleteById`) conferem com a implementação do `SolicitacaoRepository.kt`.
*   O uso de `SharingStarted.WhileSubscribed(5000)` segue a boa prática de manter o fluxo ativo apenas enquanto a tela estiver visível, com um pequeno buffer para mudanças de configuração.

## Próximos Passos
*   Registrar a entidade `Solicitacao` e o `SolicitacaoDao` no `AgroAjudaDatabase.kt` para permitir que o Room gere as tabelas.
*   Instanciar o ViewModel na `TelaDetalhes` e implementar a ação do botão "Solicitar Assistência".
