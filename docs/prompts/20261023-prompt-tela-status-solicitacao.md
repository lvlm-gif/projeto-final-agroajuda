Modifique diretamente o código da tela de status das solicitações do aplicativo AgroAjuda, acessada pelo ícone de informação (i) na tela principal.

Quero que essa tela mostre uma lista de solicitações fictícias para o usuário consultar.

Requisitos:
- Exibir o título "Minhas solicitações".
- Mostrar uma lista de solicitações.
- Cada solicitação deve apresentar informações básicas, como o nome do profissional, a descrição resumida e o status atual.
- Mostrar status como "Pendente", "Aceita" ou "Concluída".
- Permitir que o usuário toque em uma solicitação para abrir seus detalhes em outra tela.
- Manter o ícone (i) da tela principal direcionando para essa lista.
- Deixar a interface crua, simples e funcional, utilizando componentes básicos do Jetpack Compose.
- Não investir em design, animações, sombras, ilustrações ou elementos decorativos.
- Aproveitar a tela e a navegação existentes, sem criar telas duplicadas.

REGRA OBRIGATÓRIA: NÃO MEXA NO BANCO DE DADOS. Não altere entidades, DAOs, repositórios, Room, tabelas, migrations ou operações de persistência. Não adicione dependências. Utilize dados fictícios diretamente na tela apenas para demonstração.

Analise os arquivos existentes antes de alterar o código. Faça somente as mudanças necessárias nas telas e na navegação. Siga o AGENTS.md e registre o prompt e o resultado em docs/prompts/ e docs/outputs/, atualizando o arquivo de resultado existente se esta for uma continuação da mesma tarefa.