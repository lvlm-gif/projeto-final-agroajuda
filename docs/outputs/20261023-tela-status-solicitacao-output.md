# Alteração: Listagem e Status da Solicitação

## Objetivo
Evoluir a tela de status para permitir que o usuário visualize uma lista de suas solicitações de assistência técnica agrícola e consulte o progresso detalhado de cada uma individualmente.

## O que foi feito
- **Evolução da Tela (`TelaStatusSolicitacao.kt`):**
    - A tela agora possui dois estados de visualização: **Listagem** (padrão) e **Detalhes**.
    - **Visualização de Listagem:** Implementada uma `LazyColumn` que exibe cartões simplificados com ID, nome do profissional, tipo de atendimento, data e o status textual.
    - **Visualização de Detalhes:** Ao clicar em um item da lista, a tela exibe o card de informações completas e a linha do tempo (timeline) do atendimento solicitado.
    - **Dados Fictícios:** Criada uma estrutura de dados local (`SolicitacaoFicticia`) com uma lista fixa de exemplos para demonstrar o funcionamento da navegação e dos diferentes status.
- **Navegação:**
    - Ajustada a lógica do botão "Voltar" na barra superior para alternar entre a visualização de detalhes e a listagem antes de retornar à tela inicial.
    - Mantido o botão "Voltar para o início" no rodapé da visualização de detalhes.

## Componentes Visuais Utilizados
- `LazyColumn` e `items` para a listagem eficiente.
- `Card` e `Column` para organizar as informações de cada solicitação.
- `TimelineStep` (reutilizado) para indicar visualmente as 4 etapas do atendimento.
- `Scaffold` com `CenterAlignedTopAppBar` para manter a consistência com o restante do aplicativo.

## Confirmação de Banco de Dados
**Nenhuma alteração foi realizada no banco de dados Room, entidades ou repositórios.** A implementação utiliza exclusivamente dados declarados localmente no arquivo da interface para fins de demonstração funcional.

## Verificação
- A compilação foi executada com sucesso.
- A navegação entre a tela inicial, a lista de status e os detalhes de cada solicitação está funcionando corretamente.
- O layout permanece responsivo e alinhado à identidade visual do AgroAjuda.
