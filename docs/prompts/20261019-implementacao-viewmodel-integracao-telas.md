# Integração da Camada de Dados - Parte 3: ViewModel e Telas (19/10/2026)

**Objetivo:** Criar o `ProfissionalViewModel` e integrar as telas de listagem (`TelaPrincipal`) e cadastro (`TelaCadastro`) com o banco de dados Room.

## Instruções específicas:
1.  **ViewModel:** Criar `app/src/main/java/com/example/agroajuda/ui/viewmodel/ProfissionalViewModel.kt`.
    *   Utilizar `ProfissionalRepository`.
    *   Expor `allProfissionais` como `StateFlow`.
    *   Implementar `insertProfissional(profissional: Profissional)`.
    *   Implementar um `ViewModelFactory` para instanciar o ViewModel com o repositório, dado que não há DI.
2.  **Integração na Navegação:** Modificar `NavGraph.kt` para instanciar o ViewModel e passá-lo para as telas.
3.  **TelaPrincipal:**
    *   Receber o `ProfissionalViewModel`.
    *   Coletar `allProfissionais` e exibir na lista.
4.  **TelaCadastro:**
    *   Receber o `ProfissionalViewModel`.
    *   Chamar a inserção ao clicar em cadastrar.
    *   Navegar de volta após o sucesso.
5.  **Restrições:**
    *   Seguir `AGENTS.md`.
    *   Preservar a identidade visual (Material 3, cores GreenDark, GreenPrimary).
    *   Não adicionar dependências.
