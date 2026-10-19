# Alteração: Adicionar foto ao cadastro do profissional

## Objetivo
Permitir que o usuário selecione uma foto da galeria para identificar o profissional no cadastro e visualizar essa imagem na tela de detalhes.

## O que foi feito
- **Modelo de Dados:** Adicionado o campo `fotoUri: String?` à entidade `Profissional` para persistir a referência da imagem no banco de dados local (Room).
- **Banco de Dados:** Atualizada a versão do banco para 2 com a política de migração `fallbackToDestructiveMigration()` para acomodar o novo campo.
- **Tela de Cadastro (`TelaCadastro.kt`):**
    - Integrado o `PickVisualMedia` do Android para seleção segura de imagens da galeria.
    - Adicionada uma área de visualização circular (Avatar) no topo da tela para pré-visualização da foto selecionada.
    - Implementada a lógica de permissão persistente (`takePersistableUriPermission`) para garantir que o app continue tendo acesso à imagem após o reinício do dispositivo.
    - A foto é tratada como opcional, permitindo salvar o cadastro sem imagem.
- **Tela de Detalhes (`TelaDetalhes.kt`):**
    - Substituído o ícone padrão pela imagem real do profissional quando a `fotoUri` está presente.
    - Implementado carregamento nativo de Bitmap para exibir a imagem a partir da URI.

## Resultado esperado
- O usuário pode clicar no ícone de perfil e escolher uma foto da galeria.
- A foto aparece no formulário de cadastro como miniatura.
- Após salvar, a foto é exibida na tela de detalhes do profissional.
- Se nenhuma foto for escolhida, um ícone padrão (Person) é exibido.
