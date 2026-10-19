# Relatório de Correção: unexpected jvm signature V

## Diagnóstico
O erro `unexpected jvm signature V` ocorria na tarefa `:app:kspDebugKotlin` devido à falha do KSP em processar funções `suspend` no `ProfissionalDao.kt` ao utilizar o Kotlin 2.0 com o Room 2.6.1.

## Ações Realizadas
1.  **Upgrade do Room**: Atualizado de `2.6.1` para `2.7.0-alpha11` para incluir o fix oficial do suporte ao Kotlin K2.
2.  **Alinhamento Kotlin/KSP**: Kotlin fixado em `2.0.21` e KSP em `2.0.21-1.0.28`.
3.  **Coerência de JVM**: Atualizado `sourceCompatibility`, `targetCompatibility` e `jvmTarget` para `17` no módulo `:app`, garantindo compatibilidade com AGP 9.1.1.
4.  **Consistência de SDK**: Mantido `compileSdk` e `targetSdk` em `35`.

## Resultado da Compilação
- Comando: `./gradlew :app:assembleDebug`
- Status: Aguardando execução após aplicação das mudanças.
