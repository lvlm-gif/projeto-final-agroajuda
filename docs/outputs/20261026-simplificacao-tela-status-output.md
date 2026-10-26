# Alteração: Simplificação da tela de status da solicitação

## Objetivo
Remover toda a estilização avançada e elementos visuais complexos da tela de status, deixando a interface puramente básica, crua e funcional, conforme as novas diretrizes de escopo do projeto.

## O que foi feito
- **Remoção de Elementos de Design:** Foram removidos componentes como `Scaffold`, `CenterAlignedTopAppBar`, `Card`, sombras, bordas arredondadas e o componente customizado de linha do tempo (`TimelineStep`).
- **Uso de Componentes Básicos:** A tela foi reconstruída utilizando apenas componentes fundamentais do Jetpack Compose: `Column`, `Row`, `LazyColumn`, `Text`, `Button`, `Spacer` e `HorizontalDivider`.
- **Interface Funcional:**
    - A listagem de solicitações agora é exibida em uma lista simples separada por divisores horizontais.
    - A visualização de detalhes apresenta as informações em texto plano.
    - O andamento do processo é indicado por marcadores de texto simples (ex: "[ATUAL]", "OK", "Pendente").
- **Manutenção da Lógica:** As funcionalidades de alternar entre a lista e os detalhes, bem como o uso de dados fictícios para demonstração, foram preservadas integralmente.

## Arquivos modificados
- `app/src/main/java/com/example/agroajuda/ui/ui/features/TelaStatusSolicitacao.kt`

## Confirmação de Banco de Dados
**Nenhuma alteração foi realizada no banco de dados Room, entidades ou repositórios.** A alteração focou exclusivamente na simplificação da interface do usuário e na organização dos componentes básicos.

## Verificação
- A compilação foi executada com sucesso.
- A navegação entre a tela inicial, a lista simplificada e os detalhes básicos está funcionando corretamente.
- A interface agora segue o padrão de "design cru" estabelecido para esta fase do desenvolvimento.
