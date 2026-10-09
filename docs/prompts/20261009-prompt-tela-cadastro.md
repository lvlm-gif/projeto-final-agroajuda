Antes de começar, leia `docs/PRD.md`, `docs/CANVAS.md` e `AGENTS.md`, caso esteja na raiz do projeto. Analise também o código existente e a imagem de referência da tela de cadastro.

Implemente somente o visual da tela de cadastro, utilizando Kotlin e Jetpack Compose, respeitando a arquitetura MVVM e a navegação existentes.

## Descrição visual

- **Fundo:** branco quente (#F7F7F2), mantendo a identidade visual da tela inicial.
- **Barra superior:** seta de voltar no canto esquerdo e título "Criar cadastro" centralizado, em texto escuro e negrito.
- **Campo Nome:** rótulo "Nome" e campo com o texto de exemplo "Digite seu nome completo".
- **Campo Telefone:** rótulo "Telefone" e campo com o exemplo "(XX) XXXXX-XXXX".
- **Campo E-mail:** rótulo "E-mail" e campo com o exemplo "seu@email.com".
- **Tipo de usuário:** título "Tipo de usuário" seguido de duas opções com botões de seleção circular: "Agrônomo" e "Técnico Agrícola". A primeira opção deve aparecer selecionada inicialmente, como na referência.
- **Campo Especialização:** rótulo "Especialização" e campo com o exemplo "Ex.: Solo e adubação".
- **Botão Cadastrar:** botão largo, quase ocupando toda a largura disponível, com fundo verde (#397D45), texto branco, cantos arredondados e altura aproximada de 48 dp.

## Estilo dos campos

- Rótulos alinhados à esquerda, em texto escuro e sem negrito exagerado.
- Campos com fundo branco, bordas finas cinza-claro, cantos arredondados e altura aproximada de 42 a 48 dp.
- Textos de exemplo em cinza médio.
- Espaçamento vertical consistente entre rótulos e campos.
- Margens laterais próximas de 20 dp.
- Aparência simples, organizada e adequada para celular.

## Comportamento e limites

Reaproveite a tela de cadastro e os componentes existentes, especialmente `TelaCadastro.kt`, se for o arquivo utilizado atualmente.

Mantenha a navegação de voltar já existente. Preserve os campos e estados que já estiverem implementados.

Não implemente banco de dados, chamadas de API, autenticação ou novas regras de negócio. Não crie novas telas e não altere a tela inicial ou a tela de detalhes.

Primeiro, apresente um plano curto e liste os arquivos que pretende modificar. Não escreva código nem modifique arquivos até minha aprovação.