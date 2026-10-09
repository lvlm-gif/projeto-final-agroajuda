Antes de começar, leia `docs/PRD.md`, `docs/CANVAS.md` e `AGENTS.md`, caso esteja na raiz do projeto. Analise também o código existente e utilize a imagem de referência fornecida.

Implemente somente o visual da tela inicial do AgroAjuda, utilizando Kotlin e Jetpack Compose, respeitando a arquitetura e a navegação existentes.

## Descrição visual

- **Fundo:** branco quente (#F7F7F2), com aparência limpa e acolhedora.
- **Logo:** símbolo de folhas verdes centralizado na parte superior, seguido do nome AgroAjuda em fonte grande, sem serifa e em negrito. Use verde-escuro (#183D27) em "Agro" e verde principal (#397D45) em "Ajuda".
- **Descrição:** abaixo da logo, exiba "Assistência técnica para ajudar sua produção", centralizado e dividido em duas linhas, com texto cinza-escuro.
- **Botão Cadastrar:** centralizado abaixo da descrição, com fundo verde (#397D45), texto branco, cantos arredondados e altura aproximada de 48 dp.
- **Paisagem agrícola:** utilize uma ilustração suave de colinas verdes e folhagens na região central e inferior, com tons claros (#B9D1A8), sem prejudicar a leitura.
- **Seção de profissionais:** na metade inferior, crie um painel branco com cantos superiores arredondados e o título "Profissionais disponíveis", alinhado à esquerda, em verde-escuro e negrito.
- **Cartões:** apresente três cartões brancos empilhados verticalmente, com cantos arredondados e sombra discreta. Cada um deve ter uma foto quadrada com cantos arredondados à esquerda, nome em negrito, profissão abaixo em texto menor e uma seta à direita.
- **Espaçamento:** mantenha margens laterais equilibradas, elementos centralizados no cabeçalho e espaçamento confortável entre os cartões.
- **Responsividade:** permita rolagem vertical quando necessário e evite sobreposições ou textos cortados.

## Regras

Reutilize os recursos visuais existentes em `assets` e `app/src/main/res/drawable`, se disponíveis. Não invente imagens nem adicione dependências desnecessárias.

Reaproveite os callbacks de cadastro e seleção de profissional existentes. Não crie novas telas, funcionalidades ou regras de negócio.

Primeiro, apresente um plano curto e liste os arquivos que pretende alterar. Não escreva código nem modifique arquivos até minha aprovação.