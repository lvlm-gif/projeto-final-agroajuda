# Integração da Entidade Solicitacao no Room Database

Data: 2026-10-22
Tarefa: Registrar a entidade Solicitacao e seu DAO no AgroAjudaDatabase, implementando migração manual.

## Prompt
Integre a entidade `Solicitacao` ao banco Room existente do AgroAjuda. Analise os arquivos atuais antes de alterar qualquer coisa.

Adicione `Solicitacao` e seu DAO ao `AgroAjudaDatabase`, atualize a versão do banco de 3 para 4 e crie a migração `MIGRATION_3_4` para criar a tabela `solicitacoes`, mantendo a migração `MIGRATION_2_3` da entidade `Cliente`. Preserve as implementações existentes de `Cliente` e `Profissional` e não use `fallbackToDestructiveMigration()`.

Não altere telas ou arquivos fora do necessário. Ao terminar, compile o projeto e informe o resultado. Não faça commit automaticamente.

Documente o prompt em `docs/prompts` e o resultado em `docs/outputs`, seguindo o padrão já utilizado no projeto.
