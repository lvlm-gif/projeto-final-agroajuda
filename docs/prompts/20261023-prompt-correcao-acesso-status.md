# Prompt: Correção do acesso à tela de status da solicitação

## Objetivo
Corrigir o problema onde o ícone de informações na tela inicial não executava nenhuma ação ao ser tocado, impedindo o acesso à tela de status da solicitação.

## Problema Identificado
O `IconButton` estava declarado no início do `Box` na `TelaPrincipal.kt`, fazendo com que a `Column` principal (que preenche toda a tela) ficasse por cima dele, bloqueando os eventos de clique.

## Requisitos de Correção
- Ajustar a hierarquia visual para tornar o ícone clicável.
- Garantir que a ação de clique dispare a navegação para a rota de status já existente.
- Corrigir eventuais erros de referência no grafo de navegação.
