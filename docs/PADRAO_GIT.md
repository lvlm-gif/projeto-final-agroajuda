# 📜 Padrão de Branches e Commits (PADRAO_GIT.md)

Este documento define as diretrizes para a nomenclatura de branches e mensagens de commit que devem ser seguidas por todas as integrantes da equipe do projeto **AgroAjuda**. A padronização facilita a colaboração, organiza o histórico de alterações e agiliza a revisão de código.

---

## 1. Objetivo

A adoção de um padrão comum é fundamental para:
- **Organização:** Facilitar a busca por alterações específicas no histórico do Git.
- **Rastreabilidade:** Identificar rapidamente o propósito de cada branch e commit.
- **Colaboração:** Reduzir conflitos e facilitar o entendimento do trabalho das colegas durante os Pull Requests.
- **Profissionalismo:** Manter o repositório limpo e bem estruturado, seguindo boas práticas de desenvolvimento.

---

## 2. Padrão de Nomenclatura das Branches

As branches devem seguir o formato: `tipo/descricao-curta`

**Regras:**
- Letras minúsculas.
- Sem acentos ou caracteres especiais.
- Palavras separadas por hifens (`-`).

### Tipos de Branch
| Prefixo | Descrição |
| :--- | :--- |
| `feature/` | Implementação de novas funcionalidades ou telas. |
| `fix/` | Correção de bugs ou comportamentos inesperados. |
| `docs/` | Alterações exclusivas em documentação. |
| `refactor/` | Melhorias no código que não alteram a funcionalidade. |
| `test/` | Criação ou atualização de testes unitários ou de UI. |
| `style/` | Ajustes visuais, formatação ou CSS/Compose UI que não mudam a lógica. |

### Exemplos práticos:
- `feature/tela-detalhes-solicitacao`
- `feature/integracao-retrofit-api`
- `fix/erro-navegacao`
- `docs/padrao-git`
- `refactor/componentes-compose`
- `test/validacao-solicitacao`
- `style/ajustes-interface`

> **Nota:** Evite desenvolver diretamente na branch principal (`master`). Crie sempre uma branch a partir da `master` atualizada.

---

## 3. Padrão das Mensagens de Commit

As mensagens de commit devem seguir o formato: `tipo: descricao curta`

**Regras:**
- Mensagem objetiva e em português.
- Descrição em letras minúsculas (sempre que possível).
- **Sem ponto final** ao final da linha.

### Tipos de Commit
| Tipo | Quando usar |
| :--- | :--- |
| `feat:` | Adição de uma nova funcionalidade. |
| `fix:` | Correção de um erro. |
| `docs:` | Mudanças na documentação. |
| `refactor:` | Mudança no código que não corrige erro nem adiciona funcionalidade. |
| `test:` | Adição ou correção de testes. |
| `style:` | Mudanças que não afetam o significado do código (espaços, formatação, etc). |
| `chore:` | Atualizações de build, dependências, configurações (Gradle, etc). |

### Exemplos práticos:
- `feat: adiciona tela de detalhes da solicitacao`
- `feat: integra retrofit com a api`
- `fix: corrige navegacao entre telas`
- `docs: documenta padrao de branches e commits`
- `refactor: organiza componentes da interface`
- `test: adiciona testes de solicitacao`
- `style: ajusta espacamento dos componentes`
- `chore: atualiza dependencias do projeto`

---

## 4. Fluxo de Trabalho Recomendado

Siga estes passos para garantir um fluxo de trabalho saudável:

1.  **Sincronize seu repositório local:**
    ```bash
    git checkout master
    git pull origin master
    ```
2.  **Crie uma nova branch para sua tarefa:**
    ```bash
    git checkout -b feature/nome-da-tarefa
    ```
3.  **Desenvolva e teste suas alterações.**
4.  **Verifique os arquivos modificados:**
    ```bash
    git status
    ```
5.  **Adicione as alterações e faça o commit:**
    ```bash
    git add .
    git commit -m "feat: descricao da tarefa"
    ```
6.  **Envie sua branch para o repositório remoto:**
    ```bash
    git push origin feature/nome-da-tarefa
    ```
7.  **Abra um Pull Request (PR) no GitHub** para que as colegas possam revisar.

---

## 5. Exemplos Práticos (Cenários)

| Tarefa | Branch | Mensagem de Commit |
| :--- | :--- | :--- |
| Criar tela de detalhes da solicitação | `feature/tela-detalhes-solicitacao` | `feat: adiciona tela de detalhes da solicitacao` |
| Integrar com a API de Clima | `feature/integracao-api-clima` | `feat: integra servico de clima com retrofit` |
| Criar guia de Git do projeto | `docs/padrao-git` | `docs: documenta padrao de branches e commits` |

---

## 6. Boas Práticas da Equipe

- **Commits Atômicos:** Cada commit deve representar uma única alteração lógica. Evite commits gigantescos com "várias alterações".
- **Sem Dados Sensíveis:** Nunca commite senhas, tokens de API ou informações pessoais.
- **Limpeza:** Não envie arquivos temporários ou de configuração local (como `.idea/` ou `build/`). Use o `.gitignore`.
- **Comunicação:** Se houver conflitos de merge, comunique à equipe para resolverem juntas.
- **Revisão:** Antes de fazer o commit, revise seu código para remover `println`, comentários de teste ou código morto.

---

## 7. Responsabilidade da Equipe

Todas as integrantes do **AgroAjuda** são responsáveis por manter a integridade do histórico do projeto. Este padrão deve ser seguido por todas. Sugestões de melhoria neste processo devem ser discutidas em reuniões de equipe antes de serem implementadas nesta documentação.

---
*Documento criado em: 09 de Outubro de 2026.*
