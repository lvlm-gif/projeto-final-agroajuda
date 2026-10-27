# Prompt: Criação da Entidade Cliente

## Objetivo
Reconstrução do prompt utilizado para definir a classe de domínio e entidade do Room para a funcionalidade de Clientes.

## Conteúdo do Prompt (Reconstruído)
Crie a entidade `Cliente` para o projeto AgroAjuda. A classe deve ser uma `data class` em Kotlin e estar preparada para uso com o Room Database.

**Requisitos:**
- Nome da tabela no banco de dados: `clientes`.
- Campos obrigatórios conforme o PRD:
  - `id`: Int (Chave primária autogerada).
  - `nome`: String.
  - `telefone`: String.
  - `email`: String.
  - `localizacao`: String.
- Certifique-se de usar as anotações `@Entity` e `@PrimaryKey` corretamente.
- Coloque o arquivo no pacote `com.example.agroajuda.model`.
