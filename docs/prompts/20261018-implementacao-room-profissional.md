# Implementação da Camada de Dados - Parte 1: Entidade e DAO (18/10/2026)

**Objetivo:** Adaptar o modelo de dados `Profissional` para funcionar com a biblioteca Room e criar a interface de acesso aos dados (DAO) para permitir o cadastro e a listagem de profissionais.

## Instruções específicas:
1.  **Entidade:** Modificar `app/src/main/java/com/example/agroajuda/model/Profissional.kt` adicionando as anotações `@Entity(tableName = "profissionais")` e `@PrimaryKey(autoGenerate = true)` no campo `id`.
2.  **DAO:** Criar a interface `ProfissionalDao` em `app/src/main/java/com/example/agroajuda/data/local/dao/` contendo:
    *   `@Query("SELECT * FROM profissionais") fun getAllProfissionais(): Flow<List<Profissional>>`
    *   `@Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertProfissional(profissional: Profissional)`
3.  **Restrições:**
    *   Não alterar a lógica de UI ou navegação.
    *   Respeitar a arquitetura MVVM.
    *   Garantir o uso correto de Coroutines e Flow.
    *   Não modificar versões de dependências.
