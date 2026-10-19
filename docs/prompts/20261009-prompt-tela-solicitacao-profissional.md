Antes de começar, leia `docs/PRD.md`, `docs/CANVAS.md` e `AGENTS.md`, caso esteja na raiz do projeto. Analise também o código existente e a imagem de referência da tela de detalhes.

Implemente somente o visual da tela de detalhes do AgroAjuda, utilizando Kotlin e Jetpack Compose, respeitando a arquitetura MVVM e a navegação existentes.

## Descrição visual

- **Fundo:** branco quente (#F7F7F2), mantendo a identidade visual das outras telas.
- **Barra superior:** seta de voltar à esquerda e título "Detalhes do profissional".
- **Foto:** imagem do profissional centralizada, com tamanho destacado e cantos arredondados.
- **Nome:** nome do profissional em fonte grande, negrito e verde-escuro (#183D27).
- **Profissão:** apresentada abaixo do nome, em texto menor e cinza-escuro.
- **Especialização:** seção com o título "Especialização" e a informação correspondente.
- **Telefone:** informação de contato apresentada de forma organizada.
- **Descrição profissional:** texto com informações do profissional, respeitando os dados e campos já existentes no projeto.
- **Botão Solicitar atendimento:** botão largo, com fundo verde (#397D45), texto branco e cantos arredondados.

## Estilo

Utilize margens equilibradas, espaçamento vertical consistente, cartões discretos quando necessários e textos legíveis. Mantenha a identidade visual do AgroAjuda e adapte a interface a diferentes tamanhos de celular.

## Regras

Reutilize os arquivos, o modelo `Profissional` e os callbacks existentes, especialmente `TelaDetalhes.kt`, se corresponder à implementação atual.

Não invente dados, crie novas telas, funcionalidades, regras de negócio ou dependências. Não implemente API nem banco de dados nesta etapa.

Primeiro, apresente um plano curto e liste os arquivos que pretende alterar. Não escreva código nem modifique arquivos até minha aprovação.