# Prompt: Correção definitiva do erro [ksp] java.lang.IllegalStateException: unexpected jvm signature V

## Contexto
O projeto está enfrentando um erro crítico durante a compilação na tarefa `:app:kspDebugKotlin`. O erro é `unexpected jvm signature V`, que ocorre quando o processador de símbolos do KSP falha ao interpretar assinaturas de métodos, especificamente em funções `suspend` dentro de DAOs do Room ao utilizar o compilador Kotlin 2.0 (K2).

## Objetivo
1. Analisar as versões de AGP, Kotlin, KSP, Room e JDK.
2. Identificar incompatibilidades baseando-se no issue #2177 do KSP e documentação do Room.
3. Aplicar uma combinação estável de versões que suporte o compilador Kotlin 2.x e o processamento de corrotinas no Room.
4. Validar com `assembleDebug`.

## Análise Técnica
- **Erro**: `unexpected jvm signature V`. O 'V' indica `void` (ou `Unit` em Kotlin). O KSP falha ao mapear o retorno de funções suspensas que não retornam valor explicitamente.
- **Causa**: O compilador Kotlin 2.0 mudou a geração de metadados. O Room 2.6.1 e versões antigas do KSP 2.0 não lidam corretamente com essa mudança.
- **Solução Proposta**: Upgrade do Room para 2.8.5 e alinhamento do KSP para a revisão 1.0.28+, além de elevar o `jvmTarget` para 17 para compatibilidade com AGP 9.1.1.
