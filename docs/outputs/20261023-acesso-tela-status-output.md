# Alteração: Adicionar acesso à tela de status da solicitação

## Objetivo
Disponibilizar um ponto de acesso na tela inicial para que o usuário possa navegar até a tela de status da solicitação, permitindo o acompanhamento de seus pedidos.

## O que foi feito
- **Navegação:** Atualizado o `NavGraph.kt` para passar o callback de clique do botão de status para a `TelaPrincipal`.
- **Tela Inicial (`TelaPrincipal.kt`):**
    - Adicionado um `IconButton` no canto superior direito da tela, utilizando o ícone `Icons.Default.Info`.
    - O botão foi posicionado de forma absoluta dentro do `Box` principal para garantir que esteja acessível no cabeçalho.
    - Mantidos todos os estilos, cores (`GreenDark`) e layouts originais da tela.
- **Fluxo:** O clique no ícone dispara a navegação para a rota `status_solicitacao` já configurada no projeto.

## Arquivos modificados
- `app/src/main/java/com/example/agroajuda/ui/ui/features/TelaPrincipal.kt`
- `app/src/main/java/com/example/agroajuda/ui/ui/navigation/NavGraph.kt`

## Verificação
- A compilação foi verificada e o projeto executa sem erros.
- O ícone aparece corretamente no canto superior direito da tela inicial.
- Ao clicar no ícone, o aplicativo navega corretamente para a tela de Status da Solicitação.
- O layout da lista de profissionais e o botão de cadastro permanecem inalterados.

## Confirmação de Banco de Dados
**Nenhuma alteração foi realizada no banco de dados Room ou nas entidades.** A alteração é puramente de interface e navegação.
