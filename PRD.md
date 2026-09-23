# 📄 PRD — Documento de Requisitos do Produto

|                         |                                                                                          |
| ----------------------- | ---------------------------------------------------------------------------------------- |
| **App**                 | AgroAjuda                                                                                |
| **Grupo**               |                                                                                          |
| **Autores**             | Maria Miriam Marques Dos Santos, Larissa Vitória Lira de Miranda e Taiane Duarte Rezende |
| **Turma**               | A3 — 3º ano Ensino Médio                                                                 |
| **Repositório**         | https://github.com/mmms6-create/AgroAjuda.git                                            |
| **Versão do documento** | 1.0                                                                                      |
| **Última atualização**  | 23/09/2026                                                                               |
| **Status**              | (X) Rascunho ( ) Em revisão ( ) Aprovado                                                 |

---

## 1. Visão do produto

**Pitch:**
O AgroAjuda ajuda pequenos agricultores a encontrar e solicitar assistência técnica sem precisar de deslocamento.

**Problema:**
Pequenos agricultores podem ter dificuldades para encontrar profissionais de assistência técnica quando possuem dúvidas ou problemas na produção. A falta de orientação rápida pode dificultar a tomada de decisões no cultivo e aumentar possíveis prejuízos.

Atualmente, o agricultor pode precisar procurar profissionais conhecidos, órgãos de assistência ou se deslocar para encontrar alguém que possa ajudar.

**Por que vale a pena fazer isso:**
O AgroAjuda facilita a busca por profissionais de assistência técnica, permitindo que o agricultor encontre profissionais cadastrados e envie uma solicitação pelo celular.

---

## 2. Público e cenário de uso

**Usuário-alvo:**
Pequenos agricultores de diferentes idades que precisam de orientação ou assistência técnica para suas atividades agrícolas.

**História de uso:**

> "Um agricultor está com uma dúvida ou problema em sua produção. Ele abre o AgroAjuda pelo celular, visualiza os agrônomos e técnicos agrícolas disponíveis, escolhe um profissional e solicita assistência técnica. Depois do envio, o aplicativo apresenta uma mensagem confirmando a solicitação."

---

## 3. Objetivos e não-objetivos

**Objetivos desta versão (v1.0):**

1. Cadastrar e listar agrônomos e técnicos agrícolas disponíveis.
2. Permitir que o usuário visualize as informações dos profissionais.
3. Permitir que o usuário solicite assistência técnica e receba uma confirmação.

**Não-objetivos (fora do escopo):**

* ❌ Chat em tempo real entre agricultor e profissional.
* ❌ Pagamento de consultas pelo aplicativo.
* ❌ Localização e GPS em tempo real.

---

## 4. Requisitos funcionais

| ID   | História de usuário                                                                                                    | Critério de aceite                                                                                                  | Prioridade |
| ---- | ---------------------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------- | ---------- |
| RF01 | Como agricultor, quero visualizar profissionais disponíveis para encontrar alguém que possa me ajudar.                 | Ao abrir a tela principal, os profissionais cadastrados aparecem em uma lista.                                      | Must       |
| RF02 | Como usuário, quero cadastrar um agrônomo ou técnico agrícola para que ele apareça entre os profissionais disponíveis. | Ao preencher os campos obrigatórios e salvar, o profissional é armazenado no banco e aparece na lista.              | Must       |
| RF03 | Como agricultor, quero visualizar as informações de um profissional antes de solicitar assistência.                    | Ao selecionar um profissional, seus dados cadastrados são apresentados.                                             | Must       |
| RF04 | Como agricultor, quero solicitar assistência técnica a um profissional.                                                | Ao selecionar um profissional e confirmar a solicitação, o aplicativo salva a solicitação e mostra uma confirmação. | Must       |
| RF05 | Como usuário, quero visualizar o status da solicitação.                                                                | Após uma solicitação ser registrada, seu status é apresentado ao usuário.                                           | Should     |
| RF06 | Como usuário, quero receber uma mensagem quando ocorrer algum erro.                                                    | Quando uma operação falhar, o aplicativo permanece aberto e apresenta uma mensagem clara.                           | Must       |

---

## 5. Requisitos não funcionais

| ID    | Requisito                                                                     | Como será verificado                              |
| ----- | ----------------------------------------------------------------------------- | ------------------------------------------------- |
| RNF01 | O aplicativo não deve fechar sozinho durante o uso normal.                    | Usar o aplicativo por pelo menos 5 minutos.       |
| RNF02 | Os dados devem ser armazenados localmente utilizando Room.                    | Verificação do banco de dados e do código.        |
| RNF03 | O aplicativo deve utilizar arquitetura MVVM.                                  | Verificação da organização do projeto.            |
| RNF04 | A interface deve utilizar Jetpack Compose e Material 3.                       | Verificação do código e da interface.             |
| RNF05 | O aplicativo deve apresentar mensagens claras em situações de erro.           | Testes de falha no salvamento e consulta.         |
| RNF06 | A cor principal do aplicativo deve ser `#4CAF50`.                             | Verificação visual e do `Color.kt`.               |
| RNF07 | O aplicativo deve funcionar no Android definido pelo `minSdk` do projeto.     | Instalação em dispositivo ou emulador compatível. |
| RNF08 | Todas as integrantes devem conseguir realizar pequenas alterações no projeto. | Cada integrante realiza uma alteração simples.    |

---

## 6. Telas e navegação

**Mapa de navegação:**

```text
[Tela Principal]
      │
      ├── Cadastrar profissional
      │          ↓
      │   [Cadastro de Profissional]
      │          ↓
      │       Salvar
      │          ↓
      │   [Tela Principal]
      │
      └── Selecionar profissional
                 ↓
        [Detalhes do Profissional]
                 │
                 └── Solicitar assistência
                            ↓
                  [Confirmação da Solicitação]
```

| Tela                     | O que mostra                                        | Ações disponíveis                                |
| ------------------------ | --------------------------------------------------- | ------------------------------------------------ |
| Principal                | Lista de agrônomos e técnicos agrícolas disponíveis | Selecionar profissional e cadastrar profissional |
| Cadastro de profissional | Campos para cadastrar um profissional               | Preencher e salvar                               |
| Detalhes do profissional | Informações do profissional escolhido               | Solicitar assistência                            |
| Confirmação              | Confirmação da solicitação enviada                  | Visualizar confirmação/status                    |

**Rascunhos das telas:**

* `docs/telas/01-principal.png`
* `docs/telas/02-cadastro-profissional.png`
* `docs/telas/03-detalhes-profissional.png`
* `docs/telas/04-confirmacao.png`

---

## 7. Dados

### Opção A — Room

**Entidade principal:** `Profissional`

| Campo           | Tipo   | Obrigatório | Observação                   |
| --------------- | ------ | ----------- | ---------------------------- |
| `id`            | Long   | Sim         | Chave primária autogerada    |
| `nome`          | String | Sim         | Nome do profissional         |
| `tipo`          | String | Sim         | Agrônomo ou técnico agrícola |
| `especialidade` | String | Sim         | Área de atuação              |
| `telefone`      | String | Sim         | Telefone para contato        |
| `descricao`     | String | Não         | Informações adicionais       |

**Entidade:** `Solicitacao`

| Campo            | Tipo   | Obrigatório | Observação                |
| ---------------- | ------ | ----------- | ------------------------- |
| `id`             | Long   | Sim         | Chave primária autogerada |
| `profissionalId` | Long   | Sim         | Profissional escolhido    |
| `status`         | String | Sim         | Status da solicitação     |
| `data`           | String | Sim         | Data da solicitação       |

**Operações necessárias:**

* (X) inserir
* (X) listar
* ( ) atualizar
* ( ) excluir

---

## 8. Arquitetura e tecnologias

| Item                   | Escolha                         |
| ---------------------- | ------------------------------- |
| Linguagem              | Kotlin                          |
| Interface              | Jetpack Compose                 |
| Design                 | Material 3                      |
| Navegação              | Navigation Compose              |
| Arquitetura            | MVVM                            |
| Persistência           | Room                            |
| Rede                   | Retrofit 2 + Gson Converter     |
| Concorrência           | Kotlin Coroutines + Flow        |
| Injeção de dependência | Não será utilizada nesta versão |
| `minSdk` / `targetSdk` | Definir no projeto              |

**Organização de pastas:**

```text
app/src/main/java/br/edu/ifpe/agroajuda/
├── data/
│   ├── local/
│   ├── remote/
│   └── repository/
├── model/
├── ui/
│   ├── theme/
│   │   ├── Color.kt
│   │   ├── Type.kt
│   │   └── Theme.kt
│   ├── navigation/
│   │   ├── NavGraph.kt
│   │   └── NavTarget.kt
│   └── features/
└── MainActivity.kt
```

**Boilerplate inicial:**

A primeira versão do projeto deve conter apenas a infraestrutura necessária para o aplicativo compilar e executar:

* Jetpack Compose;
* Material 3;
* Navigation Compose;
* Room configurado;
* Retrofit + Gson configurados;
* Coroutines e Flow;
* KSP;
* tema básico;
* `MainActivity`;
* `NavGraph`;
* `NavTarget`.

Neste primeiro momento não serão implementadas entidades Room, DAOs, interfaces Retrofit ou ViewModels.

---

## 9. Tratamento de erros

| Situação de falha              | O que o app faz                                       | Mensagem para o usuário                                     |
| ------------------------------ | ----------------------------------------------------- | ----------------------------------------------------------- |
| Nenhum profissional cadastrado | Mostra uma mensagem informando que a lista está vazia | "Nenhum profissional cadastrado."                           |
| Campo obrigatório vazio        | Impede o cadastro                                     | "Preencha todos os campos obrigatórios."                    |
| Erro ao salvar no banco        | Mantém o aplicativo aberto e informa o erro           | "Não foi possível salvar os dados. Tente novamente."        |
| Erro ao consultar o banco      | Mantém a tela aberta                                  | "Não foi possível carregar os dados. Tente novamente."      |
| Erro ao salvar uma solicitação | Mantém a tela aberta                                  | "Não foi possível realizar a solicitação. Tente novamente." |

---

## 10. Identidade visual e publicação

| Item                          | Definição                              | Onde fica            |
| ----------------------------- | -------------------------------------- | -------------------- |
| Nome do app                   | AgroAjuda                              | `strings.xml`        |
| Cor principal                 | `#4CAF50`                              | `Color.kt`           |
| Cor secundária                | A definir                              | `Color.kt`           |
| Ícone                         | Folha verde junto com símbolo de ajuda | `loja/icone-512.png` |
| `applicationId`               | `br.edu.ifpe.agroajuda`                | `build.gradle.kts`   |
| `versionName` / `versionCode` | `1.0` / `1`                            | `build.gradle.kts`   |

**Material da loja:**

| Artefato              | Limite        | Conteúdo                                        |
| --------------------- | ------------- | ----------------------------------------------- |
| Título                | 30 caracteres | AgroAjuda                                       |
| Descrição curta       | 80 caracteres | Assistência técnica para pequenos agricultores. |
| Descrição completa    | —             | `loja/descricao.md`                             |
| Imagem de destaque    | 1024×500      | `loja/destaque-1024x500.png`                    |
| Screenshots           | Mín. 2        | `loja/screenshots/`                             |
| Esboço de privacidade | —             | `loja/privacidade.md`                           |
| Arquivo `.aab`        | —             | `loja/app-release.aab`                          |

---

## 11. Plano de testes

| #   | O que testar             | Passos                               | Resultado esperado                                | OK? |
| --- | ------------------------ | ------------------------------------ | ------------------------------------------------- | --- |
| T1  | Abrir o aplicativo       | Instalar e abrir                     | Aplicativo abre na tela principal                 |     |
| T2  | Visualizar profissionais | Abrir a tela principal               | Profissionais cadastrados aparecem na lista       |     |
| T3  | Cadastrar profissional   | Preencher cadastro e salvar          | Profissional aparece na lista                     |     |
| T4  | Visualizar informações   | Selecionar um profissional           | Informações são apresentadas                      |     |
| T5  | Solicitar assistência    | Selecionar profissional e confirmar  | Solicitação é registrada e confirmação aparece    |     |
| T6  | Campo obrigatório vazio  | Tentar salvar sem preencher um campo | Mensagem de erro aparece                          |     |
| T7  | Banco vazio              | Abrir sem profissionais cadastrados  | Mensagem de lista vazia aparece                   |     |
| T8  | Erro no banco            | Simular erro durante uma operação    | Mensagem clara aparece e o app não fecha          |     |
| T9  | Reabrir aplicativo       | Fechar e abrir novamente             | Dados salvos continuam disponíveis                |     |
| T10 | Teste externo            | Pessoa de fora utiliza o aplicativo  | Consegue realizar a ação principal sem explicação |     |

**Testado em:**

* Aparelho 1: ____________________
* Android: ____________________
* Aparelho 2: ____________________
* Android: ____________________

---

## 12. Cronograma

| Marco                                 | Prazo     | Responsável | Status    |
| ------------------------------------- | --------- | ----------- | --------- |
| M1 — Canvas + repositório             | 16/09     | Grupo       | Concluído |
| M2 — PRD aprovado + telas             | 30/09     | Grupo       |           |
| M3 — Funcionalidade base              | 21/10     | Grupo       |           |
| M4 — Dados completos e erros tratados | 11/11     | Grupo       |           |
| M5 — Identidade + `.apk` testado      | 25/11     | Grupo       |           |
| M6 — `.aab` + loja + README           | 02/12     | Grupo       |           |
| **Entrega e apresentação**            | **10/12** | **Grupo**   |           |

---

## 13. Riscos

| Risco                                     | Impacto | Plano B                                                                    |
| ----------------------------------------- | ------- | -------------------------------------------------------------------------- |
| Dificuldade na implementação do MVVM/Room | Alto    | Implementar a arquitetura por etapas, começando pela interface e ViewModel |
| Falta de tempo                            | Alto    | Priorizar as funcionalidades Must e deixar melhorias para o final          |
| Erros no banco de dados                   | Médio   | Testar cada operação do Room separadamente                                 |
| Dificuldade com Jetpack Compose           | Médio   | Manter as telas simples e implementar uma por vez                          |
| Alguma integrante não entender uma parte  | Médio   | A integrante responsável apresenta o código para as outras                 |

---

## 14. Como vamos orientar a implementação com IA

A implementação utiliza o Gemini no Android Studio.

O PRD será utilizado como referência para orientar a IA sobre o que deve ser implementado no projeto.

**Recursos que vamos usar:**

* (X) Chat
* (X) Agent Mode
* (X) Explain Code
* (X) Ask Gemini no Logcat
* (X) Generate Unit Tests
* ( ) Transform UI

**Regras do `AGENTS.md`:**

1. A IA deve manter o projeto simples e seguir a arquitetura MVVM definida pelo grupo.
2. Nenhum código será aceito sem que pelo menos uma integrante entenda o que foi alterado.
3. A IA não deve implementar funcionalidades que ainda não foram solicitadas pelo grupo.

**Combinados do grupo:**

* Ninguém aceita uma alteração do Agent Mode sem ler a mudança inteira.
* Quem aceitar o código escreve o comentário de fronteira do arquivo.
* Antes de cada marco, o grupo revisa o projeto em conjunto.
* Nenhuma chave de API ou senha será colocada no prompt.
* Todas as integrantes devem ajudar nas diferentes partes do projeto e entender o funcionamento delas.

**Divisão do perímetro explicável:**

| Parte do projeto              | Responsável                     |
| ----------------------------- | ------------------------------- |
| Telas                         | Maria Miriam Marques Dos Santos |
| Dados / Room                  | Larissa Vitória Lira de Miranda |
| Design / identidade visual    | Taiane Duarte Rezende           |
| Documentação, build e entrega | Todas                           |

**Decisões do grupo:**

* Utilizar Room para persistência local.
* Utilizar arquitetura MVVM.
* Utilizar Jetpack Compose e Material 3.
* Utilizar Navigation Compose.
* Manter o aplicativo simples.
* Não implementar chat em tempo real.
* Não implementar pagamentos.
* Não implementar GPS ou localização em tempo real.
* Todas as integrantes devem entender o código desenvolvido com auxílio da IA.

---

## 15. Histórico de versões deste documento

| Versão | Data       | Autor                                                                                    | O que mudou                       |
| ------ | ---------- | ---------------------------------------------------------------------------------------- | --------------------------------- |
| 1.0    | 23/09/2026 | Maria Miriam Marques Dos Santos, Larissa Vitória Lira de Miranda e Taiane Duarte Rezende | Criação do PRD com base no Canvas |
|        |            |                                                                                          |                                   |
