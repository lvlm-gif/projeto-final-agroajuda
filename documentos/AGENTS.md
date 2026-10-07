# AGENTS.md — AgroAjuda

## 1. Objetivo do projeto

O AgroAjuda é um aplicativo desenvolvido para facilitar o acesso de pequenos agricultores à assistência técnica agrícola.

A implementação deve seguir o que foi definido no PRD do projeto e respeitar o escopo estabelecido pelo grupo.

---

## 2. Regras para uso de IA

A IA deve seguir as seguintes regras durante o desenvolvimento:

1. Manter o projeto simples e seguir a arquitetura MVVM definida pelo grupo.

2. Nenhum código gerado ou alterado pela IA deve ser utilizado sem que pelo menos uma integrante do grupo entenda o que foi alterado.

3. A IA não deve implementar funcionalidades que ainda não foram solicitadas pelo grupo.

4. O PRD deve ser utilizado como principal referência para entender os requisitos, funcionalidades e telas do aplicativo.

5. A IA deve evitar alterações desnecessárias em arquivos que não estejam relacionados à tarefa solicitada.

6. Quando houver dúvida sobre um requisito, a IA deve priorizar o que está definido no PRD e não inventar regras ou funcionalidades.

---

## 3. Arquitetura

O projeto deve seguir a arquitetura MVVM (Model-View-ViewModel).

A organização do código deve permanecer simples e compatível com a estrutura definida pelo grupo.

Sempre que possível, novas funcionalidades devem respeitar a separação entre:

- Model: dados e modelos do aplicativo;
- View: telas e componentes da interface;
- ViewModel: gerenciamento de estado e lógica relacionada à interface.

Não devem ser adicionadas arquiteturas ou bibliotecas desnecessárias sem solicitação do grupo.

---

## 4. Tecnologias do projeto

O projeto utiliza:

- Kotlin;
- Jetpack Compose;
- Material 3;
- Navigation Compose;
- Room;
- Retrofit;
- Gson Converter;
- Coroutines;
- Flow;
- KSP.

A IA deve utilizar as tecnologias já presentes no projeto antes de sugerir novas dependências.

Não adicionar bibliotecas, frameworks ou ferramentas externas sem necessidade ou sem solicitação do grupo.

---

## 5. Implementação com Gemini no Android Studio

A implementação utiliza o Gemini integrado ao Android Studio.

O PRD será utilizado como referência para orientar a IA sobre o que deve ser implementado no projeto.

Os recursos de IA definidos pelo grupo são:

- (X) Chat
- (X) Explain Code
- (X) Ask Gemini no Logcat
- (X) Generate Unit Tests
- ( ) Transform UI

### Chat

Pode ser utilizado para tirar dúvidas, auxiliar na programação e sugerir soluções relacionadas ao projeto.

### Explain Code

Pode ser utilizado para explicar códigos existentes e ajudar as integrantes a compreenderem as alterações realizadas.

### Ask Gemini no Logcat

Pode ser utilizado para auxiliar na identificação e compreensão de erros apresentados durante a execução do aplicativo.

### Generate Unit Tests

Pode ser utilizado para auxiliar na criação de testes unitários quando houver funcionalidades que necessitem de testes.

### Transform UI

Não faz parte dos recursos definidos pelo grupo para este projeto e não deve ser utilizado como recurso planejado de implementação.

---

## 6. Controle de escopo

A IA deve trabalhar somente nas tarefas solicitadas pelo grupo.

Não deve:

- criar funcionalidades extras;
- criar telas que não foram solicitadas;
- adicionar regras de negócio não definidas;
- alterar a arquitetura do projeto sem solicitação;
- adicionar dependências desnecessárias;
- modificar arquivos sem relação com a tarefa atual.

Se uma melhoria futura for identificada, ela deve ser apenas sugerida, e não implementada automaticamente.

---

## 7. Entendimento do código

O código gerado pela IA deve ser simples, legível e compatível com o nível de conhecimento das integrantes.

Antes de considerar uma alteração concluída, pelo menos uma integrante deve compreender:

- o que foi alterado;
- por que foi alterado;
- onde a alteração foi feita;
- como a alteração funciona.

A IA deve explicar alterações importantes quando solicitado.

---

## 8. Alterações no projeto

Ao realizar uma alteração, a IA deve:

1. Verificar o código existente antes de modificá-lo.
2. Fazer somente as alterações necessárias para a tarefa.
3. Manter o padrão de organização já utilizado no projeto.
4. Evitar apagar ou substituir código sem necessidade.
5. Informar quais arquivos foram alterados.
6. Explicar as principais alterações realizadas quando necessário.

---

## 9. Regra principal

O PRD define o que o AgroAjuda deve implementar.

O AGENTS.md define como a IA deve auxiliar no desenvolvimento.

A IA deve ajudar o grupo a implementar o projeto, mas não deve tomar decisões de escopo ou implementar funcionalidades por conta própria.
