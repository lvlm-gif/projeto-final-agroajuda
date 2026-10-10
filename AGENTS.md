# 🤖 Guia de Orientação para IA (AGENTS.md)

Este documento estabelece as diretrizes, restrições e o contexto técnico para qualquer inteligência artificial que atue no projeto **AgroAjuda**. O objetivo é garantir que as contribuições da IA sejam seguras, consistentes e alinhadas com a arquitetura do projeto.

---

## 1. Contexto do Projeto
O **AgroAjuda** é um aplicativo mobile acadêmico (IFPE - Campus Palmares) desenvolvido em **Kotlin** com **Jetpack Compose**. Sua missão é conectar pequenos agricultores à assistência técnica, facilitando solicitações de serviços e o acesso a informações agrícolas.

### Estrutura de Pastas (Padrão MVVM)
A IA deve respeitar rigorosamente a seguinte organização:
- `data/local`: Entidades Room, DAOs e banco de dados.
- `data/remote`: Interfaces Retrofit, DTOs e serviços de API.
- `data/repository`: Repositórios que abstraem a fonte de dados (Local vs Remote).
- `model`: Classes de domínio/negócio.
- `ui/features`: Telas (Screens), Componentes e ViewModels organizados por funcionalidade.
- `ui/navigation`: Definições de rotas e grafo de navegação.

---

## 2. Tecnologias e Convenções
A IA deve utilizar as ferramentas já configuradas no projeto:
- **UI:** Jetpack Compose com Material Design 3.
- **Navegação:** Navigation Compose.
- **Persistência:** Room Database.
- **Rede:** Retrofit com conversor Gson.
- **Processamento:** Coroutines e Flow.
- **Injeção de Dependências:** (A confirmar no projeto, se não houver, manter instanciamento via Factory ou manual nos ViewModels).

**Regras de Código:**
- Utilize **Clean Code** e nomes de variáveis em inglês (ou conforme o padrão já estabelecido).
- Mantenha funções de Composable pequenas e reutilizáveis.
- O estado da UI deve ser gerenciado pelo **ViewModel** usando `StateFlow` ou `mutableStateOf`.

---

## 3. Diretrizes de Alteração
Ao receber uma solicitação, a IA deve:

1.  **Análise Prévia:** Ler os arquivos relacionados (ex: ler o Repository antes de alterar o ViewModel).
2.  **Escopo Estrito:** Realizar apenas as alterações solicitadas. Não tente "adivinhar" funcionalidades futuras.
3.  **Preservação:** Não remover funcionalidades existentes, comentários ou configurações de build (Gradle) sem autorização explícita.
4.  **Minimalismo:** Preferir alterações pequenas e cirúrgicas a refatorações completas.
5.  **Veracidade:** Não inventar tecnologias, bibliotecas ou dados fictícios. Se algo for incerto, pergunte ou sinalize.

---

## 4. Segurança e Dependências
- **Não adicionar novas dependências** no `build.gradle.kts` ou `libs.versions.toml` sem necessidade extrema e aviso prévio.
- **Não alterar a versão do SDK** ou plugins do Gradle.
- Respeite as configurações de permissões no `AndroidManifest.xml`.

---

## 5. Testes e Validação
A IA deve orientar a validação das alterações:
- **Testes Unitários:** Sugerir testes para lógicas de negócio em ViewModels ou Repositórios usando JUnit.
- **UI Preview:** Sempre incluir ou atualizar `@Preview` para componentes Compose.
- **Logs:** Se houver erros, instruir o uso do Logcat para depuração.

---

## 6. Comunicação Pós-Edição
Após realizar qualquer alteração, a IA deve fornecer um resumo:
- ✅ **O que foi feito:** Descrição breve da mudança.
- 📂 **Arquivos modificados:** Lista dos caminhos completos.
- 💡 **Observações:** Explicação técnica de escolhas complexas, se houver.
