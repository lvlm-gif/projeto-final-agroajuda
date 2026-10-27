# Prompt: Criação da Migração Manual (Versão 2 para 3)

## Objetivo
Reconstrução do prompt utilizado para implementar a migração segura do banco de dados, permitindo a criação da tabela de clientes sem a perda de dados dos profissionais.

## Conteúdo do Prompt (Reconstruído)
Implemente um objeto de migração `MIGRATION_2_3` no `AgroAjudaDatabase` para transicionar o banco de dados da versão 2 para a versão 3.

**Requisitos:**
- O banco deve passar da versão 2 para a 3.
- Utilize o comando SQL `CREATE TABLE IF NOT EXISTS` para criar a tabela `clientes`.
- A estrutura da tabela deve corresponder exatamente à entidade `Cliente`:
  - `id`: INTEGER, PRIMARY KEY, AUTOINCREMENT, NOT NULL.
  - `nome`: TEXT, NOT NULL.
  - `telefone`: TEXT, NOT NULL.
  - `email`: TEXT, NOT NULL.
  - `localizacao`: TEXT, NOT NULL.
- Registre esta migração no builder do Room usando `.addMigrations(MIGRATION_2_3)`.
- Remova o uso de `fallbackToDestructiveMigration()` para evitar a limpeza acidental dos dados de profissionais.
