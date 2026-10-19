# Alteração: Substituir especialização por descrição do profissional

## Objetivo
Substituir o campo "Especialização" por um campo de "Descrição do profissional" no processo de cadastro e exibição, permitindo que informações mais detalhadas sobre a experiência e serviços do profissional sejam registradas e visualizadas.

## O que foi feito
- **Modelo de Dados:** Reutilizado o campo `descricao` da entidade `Profissional` para armazenar o texto detalhado.
- **Tela de Cadastro (`TelaCadastro.kt`):**
    - O rótulo "Especialização" foi alterado para "Descrição do profissional".
    - O campo de texto foi configurado para permitir múltiplas linhas (`singleLine = false`), facilitando a inserção de textos longos.
    - A lógica de salvamento foi atualizada para atribuir o valor digitado ao campo `descricao` do objeto `Profissional`.
- **Tela de Detalhes (`TelaDetalhes.kt`):**
    - A exibição da especialidade foi removida para dar lugar à descrição detalhada.
    - Adicionada a seção "Sobre o profissional", que exibe o conteúdo do campo `descricao` salvo no banco de dados.
    - Implementado tratamento para exibir uma mensagem padrão ("Sem descrição disponível") caso o campo esteja vazio.

## Resultado esperado
- O usuário consegue digitar uma descrição completa durante o cadastro.
- A descrição é persistida corretamente no banco de dados local (Room).
- Ao visualizar os detalhes de um profissional, o agricultor pode ler o texto descritivo completo em uma seção dedicada.
