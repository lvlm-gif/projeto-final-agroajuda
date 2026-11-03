# Prompt: Implementação de Telas Cruas de Login e Cadastro de Cliente

## Objetivo
Implementar as interfaces de Login e Cadastro de Cliente no projeto AgroAjuda, focando em simplicidade absoluta (interface crua) e navegação funcional, sem integração com banco de dados.

## Requisitos solicitados
- **Estilo**: Fundo branco, textos pretos/cinzas, botões e campos básicos. Sem cores personalizadas ou decorações.
- **Login**:
    - Campos: E-mail e Senha (obrigatórios).
    - Validação simples de campos vazios.
    - Navegação para a Home se preenchido.
    - Link para Cadastro de Cliente.
- **Cadastro de Cliente**:
    - Baseado na estrutura da tela de cadastro de Profissional.
    - Campos: Nome, Telefone, E-mail e Descrição (obrigatórios).
    - Sem seleção de tipo (Agrônomo/Técnico).
    - Validação de campos vazios.
    - Retorno para a tela de Login ao finalizar.
- **Navegação**: Login como tela inicial (`startDestination`).
- **Restrição**: Proibido alterar qualquer arquivo de banco de dados (Room, DAOs, Entidades).
