# Prompt: Criação do ClienteDao

## Objetivo
Reconstrução do prompt utilizado para definir a interface de acesso a dados (DAO) da funcionalidade de Clientes.

## Conteúdo do Prompt (Reconstruído)
Crie a interface `ClienteDao` no pacote `com.example.agroajuda.data.local.dao`. Esta interface deve gerenciar as operações de persistência para a entidade `Cliente`.

**Requisitos:**
- Inserir um cliente (usar `OnConflictStrategy.REPLACE`).
- Listar todos os clientes ordenados por nome em ordem ascendente (retornar um `Flow<List<Cliente>>`).
- Excluir um cliente.
- As funções de escrita (`insert` e `delete`) devem ser `suspend`.
- Utilize as anotações do Room (`@Dao`, `@Insert`, `@Query`, `@Delete`).
