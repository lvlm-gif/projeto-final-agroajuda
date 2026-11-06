# Prompt: Implementação da Descrição da Solicitação

## Objetivo
Adicionar uma funcionalidade que permite ao cliente descrever sua necessidade antes de confirmar uma solicitação de atendimento a um profissional.

## Requisitos solicitados
1. **Tela de Detalhes do Profissional**: Adicionar botão "Solicitar atendimento" que navega para a nova tela de descrição.
2. **Nova Tela: Descrição da Solicitação**:
    - Estilo cru (fundo branco, componentes básicos).
    - Título "Descreva sua solicitação".
    - Texto orientador.
    - Campo de texto grande obrigatório com validação.
    - Botão "Enviar solicitação".
3. **Navegação e Fluxo**: 
    - Detalhes -> Descrição -> Confirmação.
    - Passagem da descrição escrita para a tela de confirmação.
4. **Tela de Confirmação**: Atualizar para exibir a descrição informada pelo cliente.
5. **Restrições**: Proibido alterar o banco de dados Room ou persistir dados permanentemente. Uso exclusivo de navegação e passagem de parâmetros.
