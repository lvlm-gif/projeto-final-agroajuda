# 🎯 Canvas do Projeto Final — App Android

> **Como usar:** este é o primeiro documento do projeto. Preencha em grupo, em uma única aula, **antes de escrever qualquer linha de código**. Cada bloco tem no máximo 5 linhas — se não couber, o projeto está grande demais.
> Depois de preenchido e validado pelo professor, ele vira a base do [`PRD.md`](PRD.md).

| | |
|---|---|
| **Grupo nº** | |
| **Integrantes: Maria Miriam Marques Dos Santos, Larissa Vitória Lira de Miranda e Taiane Duarte Rezende** | |
| **Turma: A3 ** | 3º ano — Ensino Médio |
| **Repositório** | https://github.com/mmms6-create/AgroAjuda.git |
| **Data de preenchimento** | 17/09/2026 |
| **Entrega final** | **10/12/2026** |

---

## 🧩 Bloco 1 — Nome e pitch do app

**Nome do app: AgroAjuda ** 

**Pitch em uma frase:**
> "O AgroAjuda ajuda pequenos agricultores a achar e solicitar assistência técnica sem precisar de deslocamento."


---

## 😖 Bloco 2 — Problema

Qual dor real vocês estão resolvendo? Descrevam uma situação concreta que alguém vive hoje.

Pequenos agricultores podem ter dificuldades para encontrar profissionais de assistência técnica quando possuem dúvidas ou problemas na produção, e
a falta de orientação rápida pode dificultar a tomada de decisões no cultivo e aumentar os prejuízos.

**Como esse problema é resolvido hoje (sem o app)?**

O agricultor procura profissionais conhecidos, órgãos de assistência ou precisa se deslocar para encontrar alguém para o ajudar.

## 👥 Bloco 3 — Público-alvo

Para quem é o app? Sejam específicos (idade, contexto, com que frequência usariam).

- **Perfil principal: Pequenos Agricultores, de idades diversas, necessitados de orientações.
- **Quando/onde usam: Podem usar pelo celular, quando precisarem de auxílio rápido. 

- **Uma pessoa real que testaria o app: Lívia Thamires(Engenheira Agrônoma), irmã da integrante Larissa, pode usar para testes.

---

## 💡 Bloco 4 — Solução em uma tela


- **A tela principal lista: Agrônomos e técnicos agrícolas disponíveis para atendimento.**
- **A ação principal do usuário é: Escolher um profissional e solicitar assistência técnica.**
- **Depois de agir, o usuário vê: Uma mensagem confirmando que a solicitação foi enviada.**

---

## ✅ Bloco 5 — Funcionalidades do MVP


| # | Funcionalidade | Essencial? | Quem faz |
|---|---|---|---|
| F1 | | Sim |Cadastrar e listar agrônomos e técnicos disponíveis | Larissa |
| F2 | | Sim | Visualizar informações do profissional | Miriam |
| F3 | | Sim/Não | Solicitar assistência técnica | Taiane |
| F4 | | Não |Visualizar o status da solicitação | Todas |

---

## 🚫 Bloco 6 — Fora do escopo


-❌ Chat em tempo real entre agricultor e profissional.
-❌ Pagamento de consultas pelo aplicativo.
-❌ Localização e GPS em tempo real.


---

## ⚙️ Bloco 7 — Caminho técnico


- [x] **Opção A — Room:** dados salvos no próprio celular (lista de compras, agenda, diário de treino, controle financeiro)
- [ ] **Opção B — Retrofit:** dados vindos de uma API pública (notícias, filmes, feed, clima)
- [ ] **Opção C — Desafio:** API + salvar favoritos localmente

**Se escolheu B ou C — qual API?** _(link da documentação + precisa de chave? é gratuita?)_

**Bibliotecas que o grupo vai usar: Kotlin, Jetpack Compose, ViewModel, Room e Kotlin Coroutines (se preciso)**

**Onde entra o `try/catch`?** _(qual operação pode falhar: banco vazio, internet caindo, API fora do ar, campo em branco)_

- Pode falhar: Salvamento ou consulta dos dados no banco, ou envio de uma solicitação de assistência.

- O usuário vê a mensagem: "Não foi possível realizar a solicitação. Tente novamente."

---

## 🎨 Bloco 8 — Identidade visual

| Item | Definição do grupo |
|---|---|
| Nome exibido (`strings.xml`) | AgroAjuda |
| Cor principal (hex, em `Color.kt`) | #4CAF50 |
| Ideia do ícone (512×512) |Uma folha verde junto com um símbolo de ajuda. |
| `applicationId` | `br.edu.ifpe.agroajuda` |
| Versão inicial | `1.0` (versionCode `1`) |

---

## 👤 Bloco 9 — Equipe, papéis e riscos

| Integrante | Papel principal | Responsável por |
|---|---|---|
| | Dev / telas | Miriam |
| | Dev / dados (Room ou Retrofit) | Larissa  |
| | Design e identidade visual | Taiane |
| | Documentação, build e entrega | Todas |


**Riscos — o que pode dar errado e o plano B:**

| Risco |                                        | Plano B |
|
Dificuldade na implementação do MVVM/Room e 	| Implementar a arquitetura por etapas, começando pela View e ViewModel
Falta de tempo para concluir funcionalidade	| Priorizar as funcionalidades essenciais e deixar melhorias para o final|---|
| | |
| | |

---

## 🤖 Bloco 10 — Acordo de trabalho com IA


**Três regras que vamos escrever no nosso `AGENTS.md`** _(o arquivo que diz à IA como trabalhar no nosso projeto)_:

1- A IA deve manter o projeto simples e seguir a arquitetura MVVM definida pelo grupo.
2- Nenhum código será aceito sem pelo menos uma integrante entender o que foi alterado.
3- A IA não deve implementar funcionalidades que ainda não foram solicitadas pelo grupo.

**Combinados do grupo:**

- [x] Ninguém clica *Accept* no Agent Mode sem ler a mudança inteira.
- [x] Quem aceitou o código escreve o comentário de fronteira do arquivo.
- [x] Antes de cada marco, revisamos juntos: alguém aqui não entende alguma parte?
- [x] Nenhuma chave de API ou senha vai para o prompt.
- Outro combinado nosso: Todas ajudarem em todas partes e no entendimento delas. 

**Como vamos garantir que todos entendem tudo** _(ex.: quem implementa apresenta o arquivo aos outros; revezar as partes; revisar o pull request do colega)_:

Quem implementar uma parte apresenta o código às outras integrantes. O grupo vai fazer revisões conjuntas em cada etapa, e todas deverão conseguir fazer pequenas alterações no projeto.

## 🗓️ Bloco 11 — Marcos até 10/12

| Marco | Prazo | Como se comprova no GitHub |
|---|---|---|
| M1 — Canvas preenchido + repositório criado | 16/09 | `CANVAS.md` no `main` |
| M2 — PRD aprovado + telas rascunhadas | 30/09 | `PRD.md` + imagens em `docs/` |
| M3 — Funcionalidade base rodando | 21/10 | tela principal lista dados + 1 ação + `try/catch` |
| M4 — Dados completos (Room/Retrofit) e erros tratados | 11/11 | commits da camada de dados |
| M5 — Identidade visual + `.apk` de release testado | 25/11 | ícone, cores, `.apk` testado por 2 pessoas de fora |
| M6 — `.aab` + material de loja + `README.md` | 02/12 | pasta `loja/` + `README.md` completo |
| **Entrega e apresentação** | **10/12** | tag `v1.0` no repositório |

---

## 🏁 Bloco 12 — Definição de pronto

O grupo só considera o app pronto quando **todas** estas frases forem verdadeiras:

- [ ] O app abre e não fecha sozinho depois de 5 minutos de uso.
- [ ] A tela principal mostra dados reais (não texto de exemplo fixo no código).
- [ ] A ação principal funciona e o resultado aparece na tela.
- [ ] Quando algo falha, aparece uma mensagem clara — o app não quebra.
- [ ] O app tem nome, ícone e cor próprios (nada de ícone padrão do Android).
- [ ] Duas pessoas de fora do grupo instalaram o `.apk` e conseguiram usar sem explicação.
- [ ] O `README.md` explica o que o app faz, com o que foi feito e como gerar o build.
- [ ] O `docs/USO_DE_IA.md` e o `AGENTS.md` estão preenchidos.
- [ ] **Cada integrante consegue abrir o projeto e fazer uma mudança pequena sozinho** — trocar um texto, acrescentar um campo, mudar a ordem da lista.
- [ ] Todo arquivo nosso tem o comentário de fronteira escrito por nós.
