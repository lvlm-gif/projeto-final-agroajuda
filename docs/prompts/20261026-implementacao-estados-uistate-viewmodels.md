# Implementação de Estados de Interface (UiState) nos ViewModels de Cliente e Solicitação (26/10/2026)

**Objetivo:** Padronizar o tratamento de estados de carregamento, erro, sucesso e vazio nos ViewModels de `Cliente` e `Solicitacao`, seguindo o padrão já estabelecido no `ProfissionalViewModel`.

## Instruções específicas:
1.  **Análise de Padrão:** Estudar o `ProfissionalViewModel` e a interface `UiState`.
2.  **Implementação de Estados:**
    *   Criar `ClienteUiState` e `SolicitacaoUiState`.
    *   Adicionar `uiState` (StateFlow) em ambos os ViewModels.
    *   Implementar a função pública `carregar()` para gerenciar a coleta de dados e permitir tentativas em caso de erro.
3.  **Tratamento de Erros:**
    *   Utilizar blocos `try-catch` em operações de persistência.
    *   Priorizar `IOException` para erros de infraestrutura.
    *   Mapear erros para chaves de string amigáveis, evitando mensagens técnicas.
4.  **Preservação e Compatibilidade:**
    *   Não alterar Repositórios, DAOs ou Banco de Dados.
    *   Não modificar a UI ou componentes visuais.
    *   Manter propriedades de lista originais (ex: `allClientes`) para compatibilidade com observadores atuais.
5.  **Restrições de Código:**
    *   Não utilizar `else` em blocos `when` sobre classes seladas.
    *   Preservar a arquitetura MVVM e a organização do código.
