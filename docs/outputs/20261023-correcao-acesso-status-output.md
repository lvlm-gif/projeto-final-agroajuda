# Alteração: Correção do acesso à tela de status da solicitação

## Objetivo
Corrigir a falha de navegação na tela inicial onde o ícone de informações ("i") não respondia ao toque, impossibilitando o acesso à tela de status da solicitação.

## O que foi feito
- **Ajuste na `TelaPrincipal.kt`:** O `IconButton` foi movido para o final do contêiner `Box`. No Jetpack Compose, a ordem de declaração dentro de um `Box` define a profundidade (Z-order). Ao movê-lo para o final, garantimos que ele seja desenhado sobre a `Column` principal, tornando-o clicável.
- **Correção no `NavGraph.kt`:** Corrigido um erro de digitação (typo) na variável `profissionalId` (estava `professionalId`), o que impedia a compilação do projeto.
- **Sincronização na `MainActivity.kt`:** Atualizado o import do `NavGraph` para garantir que o aplicativo carregue a versão correta e mais atualizada da navegação.

## Resultado esperado
- O ícone "i" no canto superior direito agora é totalmente funcional.
- Ao clicar no ícone, o usuário é direcionado corretamente para a `TelaStatusSolicitacao.kt`.
- O projeto compila sem erros de referência.

## Confirmação de Banco de Dados
Nenhuma alteração foi realizada nas entidades, DAOs ou na estrutura do banco de dados Room.
