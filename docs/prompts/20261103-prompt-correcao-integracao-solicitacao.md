# Prompt: Corrigir integração e navegação da solicitação de atendimento

## Objetivo
Corrigir o fluxo de solicitação de atendimento no aplicativo AgroAjuda, garantindo que o usuário passe pela tela de descrição antes da confirmação e que os dados sejam transmitidos corretamente.

## Requisitos
- Analisar as telas `TelaDetalhes.kt`, `TelaDescricaoSolicitacao.kt` e `TelaConfirmacao.kt`.
- Atualizar o `NavGraph.kt` para incluir a rota de `DescricaoSolicitacao`.
- Corrigir a navegação: Detalhes -> Descrição da Solicitação -> Confirmação.
- Garantir a passagem do parâmetro `descricao` para a tela de confirmação.
- Corrigir erros de compilação remanescentes (como importações ausentes).
- Manter a integridade do banco de dados e as funcionalidades existentes.
