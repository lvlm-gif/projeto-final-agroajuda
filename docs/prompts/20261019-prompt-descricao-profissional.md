# Alteração: Substituir especialização por descrição do profissional

## Objetivo
Substituir o campo "Especialização" por "Descrição do profissional" no cadastro do AgroAjuda e exibir a descrição na tela de detalhes do profissional.

## Prompt enviado ao Gemini

Antes de realizar qualquer alteração, leia os arquivos `docs/PRD.md`, `docs/CANVAS.md` e `AGENTS.md` (ou `docs/AGENTS.md`, caso esteja nessa pasta) para entender as regras e a estrutura atual do projeto AgroAjuda.

### Objetivo
Quero substituir o campo "Especialização" por "Descrição do profissional" no cadastro do profissional e fazer com que o texto digitado nesse campo seja exibido na tela de detalhes do profissional.

### Alterações solicitadas

1. **Tela de cadastro do profissional:**
    - Substitua o campo com o rótulo "Especialização" por "Descrição do profissional".
    - Permita que o usuário escreva um texto descrevendo o profissional, seus serviços ou sua experiência.
    - Mantenha o mesmo estilo visual, as cores, o posicionamento, o tamanho e a organização atual dos elementos da tela.
    - Não crie novos campos nem altere os outros campos existentes.

2. **Salvamento no banco de dados:**
    - Verifique como os dados do profissional são atualmente enviados e salvos no banco de dados.
    - Faça com que o texto digitado em "Descrição do profissional" seja salvo corretamente e associado ao profissional cadastrado.
    - Analise a estrutura existente antes de modificar qualquer entidade, modelo, repositório ou lógica de persistência.
    - Se já existir um campo de descrição, reutilize-o em vez de criar outro desnecessariamente.
    - Preserve os demais dados e o funcionamento atual do banco de dados.

3. **Tela de detalhes do profissional:**
    - Quando o usuário abrir as informações de um profissional, exiba a descrição cadastrada.
    - Utilize o texto salvo no banco de dados, correspondente ao profissional selecionado.
    - Se o profissional ainda não tiver uma descrição preenchida, trate essa situação sem apresentar erros ou informações incorretas.
    - Mantenha a interface atual da tela de detalhes, apenas substituindo a informação de especialização pela descrição, respeitando o espaço e o estilo já existentes.

### Restrições importantes
- Não altere o design, as cores, os botões, a navegação ou a organização das telas.
- Não modifique funcionalidades que não estejam relacionadas a esta solicitação.
- Não apague dados do banco de dados nem recrie o banco sem necessidade.
- Preserve a arquitetura e a organização de pastas já utilizadas no projeto.
- Siga as regras do arquivo `AGENTS.md`.
- Faça somente as alterações necessárias para implementar essa mudança.

### Verificação final
Após implementar:
1. Confira se o projeto compila sem erros.
2. Verifique se o cadastro salva a descrição corretamente.
3. Verifique se a descrição aparece na tela de detalhes do profissional correspondente.
4. Confira se os demais dados, a navegação e a interface continuam funcionando como antes.

Ao terminar, informe quais arquivos foram modificados, explique brevemente o que mudou em cada um e indique se existe alguma etapa manual necessária para atualizar o banco de dados.

Não comece refatorações nem implemente melhorias adicionais. Faça apenas essa alteração e explique o código de maneira simples para que uma integrante do grupo consiga compreender o que foi modificado.