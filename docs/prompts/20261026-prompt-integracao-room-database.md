# Prompt: Integração da Entidade Cliente no Room Database

## Objetivo
Reconstrução do prompt utilizado para registrar a entidade `Cliente` e seu DAO no banco de dados principal do aplicativo.

## Conteúdo do Prompt (Reconstruído)
Atualize a classe `AgroAjudaDatabase` para incluir o suporte à funcionalidade de Clientes.

**Requisitos:**
- Adicionar `Cliente::class` ao array de `entities` na anotação `@Database`.
- Declarar a função abstrata `abstract fun clienteDao(): ClienteDao`.
- Realizar os imports necessários dos pacotes `model` e `dao`.
- Manter a compatibilidade com a entidade `Profissional` já existente.
