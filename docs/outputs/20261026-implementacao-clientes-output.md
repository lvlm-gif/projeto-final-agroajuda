# Relatório de Atividade: Implementação da Funcionalidade Clientes

## 1. Objetivo da Atividade
Implementar a infraestrutura de dados para a funcionalidade de Clientes no aplicativo AgroAjuda, garantindo a persistência local de informações e a organização do código seguindo a arquitetura MVVM.

## 2. Escopo Solicitado
O escopo técnico abrangeu a criação da entidade de dados, a interface de acesso (DAO), a camada de abstração (Repository), a lógica de negócio (ViewModel) e a integração segura com o banco de dados Room, incluindo a migração de esquema sem perda de dados.

## 3. Arquivos Criados e Modificados

| Arquivo | Caminho | Status |
| :--- | :--- | :--- |
| `Cliente.kt` | `app/src/main/java/com/example/agroajuda/model/` | Criado |
| `ClienteDao.kt` | `app/src/main/java/com/example/agroajuda/data/local/dao/` | Criado |
| `ClienteRepository.kt` | `app/src/main/java/com/example/agroajuda/data/repository/` | Criado |
| `ClienteViewModel.kt` | `app/src/main/java/com/example/agroajuda/ui/viewmodel/` | Criado |
| `AgroAjudaDatabase.kt` | `app/src/main/java/com/example/agroajuda/data/local/` | Modificado |

## 4. Responsabilidade de cada Arquivo

- **`Cliente.kt`**: Define a estrutura de dados (Entidade) que representa um cliente no banco de dados.
- **`ClienteDao.kt`**: Contém as consultas SQL e métodos de acesso direto ao banco SQLite via Room.
- **`ClienteRepository.kt`**: Atua como uma camada intermediária que fornece dados para o restante do app, isolando o DAO.
- **`ClienteViewModel.kt`**: Gerencia o estado da interface e executa operações de dados em segundo plano (Coroutines).
- **`AgroAjudaDatabase.kt`**: Ponto central de configuração do Room onde as entidades e migrações são registradas.

## 5. Explicação Técnica

### Camada de Modelo e Acesso (Model/DAO)
A entidade `Cliente` armazena `id`, `nome`, `telefone`, `email` e `localizacao`. O `ClienteDao` permite inserir (com estratégia de substituição em conflitos), listar de forma reativa (usando `Flow`) e excluir registros.

### Camada de Repositório e Negócio (Repository/ViewModel)
O `ClienteRepository` expõe a lista de clientes vinda do DAO. O `ClienteViewModel` transforma essa lista em um `StateFlow` seguro para o Compose e utiliza o `viewModelScope` para garantir que as operações de escrita não bloqueiem a thread principal da interface.

## 6. Integração com Room e Migração
O banco de dados foi elevado da **versão 2 para a versão 3**. 
Foi implementada a **`MIGRATION_2_3`**, que executa o comando SQL necessário para criar a tabela `clientes` manualmente. Esta abordagem foi escolhida para garantir que a tabela `profissionais` e seus registros existentes fossem integralmente preservados no dispositivo do usuário.

## 7. Problemas Encontrados e Soluções
Durante a revisão, identificou-se que o banco de dados estava configurado com `fallbackToDestructiveMigration()`, o que apagaria todos os dados ao mudar de versão. A solução foi remover essa configuração e implementar a migração manual por meio do comando `addMigrations(MIGRATION_2_3)`.

## 8. Verificação e Compilação
- **Status:** `BUILD SUCCESSFUL` verificado via Gradle.
- O código foi analisado e as referências entre DAO, Repository e ViewModel estão corretamente vinculadas.

## 9. Testes e Limitações
- **Testes Realizados:** Verificação de sintaxe e compilação do projeto. Revisão lógica do fluxo de dados no código-fonte.
- **Testes Pendentes:** Testes funcionais de inserção e deleção via interface (UI) e verificação via Database Inspector.
- **Limitações:** A funcionalidade de "Atualizar Cliente" (Update) não foi implementada nesta etapa, conforme o escopo restrito solicitado.

## 10. Conclusão e Próximos Passos
O escopo técnico da camada de dados para Clientes foi 100% cumprido. O aplicativo agora possui a infraestrutura interna necessária para gerenciar clientes de forma persistente e segura.
**Recomendação:** O próximo passo é integrar o `ClienteViewModel` ao `NavGraph` e implementar as telas de listagem e cadastro de clientes na interface do usuário.
