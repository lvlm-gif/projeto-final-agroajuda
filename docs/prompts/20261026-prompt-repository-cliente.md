# Prompt: Criação do ClienteRepository

## Objetivo
Reconstrução do prompt utilizado para definir a classe de repositório da funcionalidade de Clientes, abstraindo a fonte de dados.

## Conteúdo do Prompt (Reconstruído)
Implemente a classe `ClienteRepository` no pacote `com.example.agroajuda.data.repository`. Esta classe deve atuar como intermediária entre o DAO e o ViewModel.

**Requisitos:**
- Receber uma instância de `ClienteDao` no construtor.
- Expor uma propriedade `allClientes` do tipo `Flow<List<Cliente>>` que consome os dados do DAO.
- Implementar as funções `suspend fun insert(cliente: Cliente)` e `suspend fun delete(cliente: Cliente)` chamando os métodos correspondentes do DAO.
- Manter o código limpo e focado na delegação das operações de dados.
