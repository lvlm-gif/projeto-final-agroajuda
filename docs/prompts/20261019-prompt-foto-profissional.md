# Alteração: Adicionar foto ao cadastro do profissional

## Objetivo
Adicionar a possibilidade de selecionar uma foto da galeria do celular durante o cadastro de um profissional e que essa foto apareça na tela de detalhes desse profissional.

## Prompt enviado ao Gemini

Analise o código atual do projeto AgroAjuda antes de fazer qualquer alteração.

**Objetivo:** permitir que o usuário selecione uma foto da galeria do celular durante o cadastro de um profissional e que essa foto apareça na tela de detalhes do profissional.

### Requisitos
1. Na tela de cadastro existente, adicione uma opção para selecionar uma foto da galeria do celular.
2. Permita visualizar a foto selecionada antes de salvar o cadastro.
3. Salve a referência da foto associada ao profissional correto, garantindo que ela continue disponível após fechar e abrir o aplicativo.
4. Na tela de detalhes, exiba a foto do profissional cadastrado.
5. Se nenhuma foto for selecionada, permita salvar o cadastro normalmente.
6. Utilize o seletor de imagens do Android, sem solicitar permissões desnecessárias para acessar toda a galeria.
7. Analise a estrutura atual do banco de dados e implemente a forma mais simples e adequada de persistir a foto. Preserve os dados existentes e evite recriar o banco.
8. Se o projeto utilizar um banco remoto, verifique como a imagem deve ser armazenada para continuar acessível em outros dispositivos.

### Restrições obrigatórias
- Não altere a funcionalidade de descrição do profissional, pois ela já está implementada.
- Não modifique os outros campos do cadastro.
- Não altere cores, botões existentes, textos, dimensões ou organização visual das telas, exceto pelo mínimo necessário para adicionar a opção de foto.
- Não altere a navegação nem implemente funcionalidades extras.
- Siga a arquitetura atual e as regras do `AGENTS.md`.
- Modifique somente os arquivos necessários para essa funcionalidade.

### Verificação
Teste a seleção da foto, o salvamento do cadastro, a exibição da imagem nos detalhes e a persistência após fechar e abrir o aplicativo. Teste também o cadastro sem foto.

Ao terminar, informe quais arquivos foram alterados, explique brevemente cada mudança e indique se foi necessária alguma alteração no banco de dados. Verifique se o projeto compila sem erros.

Implemente somente essa funcionalidade, preservando todo o restante do projeto como está.