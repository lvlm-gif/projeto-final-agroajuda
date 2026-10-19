# Implementação da Camada de Dados - Parte 2: Database e Repository (18/10/2026)

**Objetivo:** Criar a classe do banco de dados Room e o repositório para o modelo `Profissional`, consolidando a infraestrutura de dados para a entrega M3.

## Instruções específicas:
1.  **Database:** Criar `app/src/main/java/com/example/agroajuda/data/local/AgroAjudaDatabase.kt`.
    *   Deve estender `RoomDatabase`.
    *   Deve incluir a entidade `Profissional`.
    *   Deve fornecer o `ProfissionalDao`.
    *   Implementar padrão Singleton para a instância do banco.
2.  **Repository:** Criar `app/src/main/java/com/example/agroajuda/data/repository/ProfissionalRepository.kt`.
    *   Deve receber `ProfissionalDao` no construtor.
    *   Deve expor `getAllProfissionais(): Flow<List<Profissional>>`.
    *   Deve expor `insertProfissional(profissional: Profissional)`.
3.  **Restrições:**
    *   Não alterar a UI, navegação ou modelos existentes.
    *   Seguir o padrão MVVM e as diretrizes do `AGENTS.md`.
    *   Utilizar Coroutines e Flow conforme configurado.
