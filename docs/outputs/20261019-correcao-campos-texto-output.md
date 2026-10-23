# Alteração: Corrigir textos cortados nos campos

## Objetivo
Resolver problemas de legibilidade e falhas visuais onde o conteúdo digitado nos campos de formulário aparecia cortado na parte inferior ou com cores excessivamente claras.

## O que foi feito
- **Ajuste de Altura:** Aumentada a altura dos campos de entrada (Nome, Telefone e E-mail) de 48dp para **56dp**. Esta mudança foi necessária pois o preenchimento interno (*padding*) padrão do Material 3 estava comprimindo a área de texto em alturas menores.
- **Melhoria de Legibilidade:**
    - Definida explicitamente a cor do texto digitado como `Color.Black` (`focusedTextColor` e `unfocusedTextColor`).
    - Ajustada a cor do texto de exemplo (*placeholder*) para um cinza visível, garantindo contraste adequado.
- **Alinhamento e Estilo:**
    - Removido o uso de `Modifier.background` externo, utilizando agora as propriedades de contêiner do próprio `OutlinedTextFieldDefaults` para evitar conflitos de renderização.
    - O campo de **Descrição** teve sua altura mínima definida para **100dp**, garantindo uma área de digitação confortável para múltiplos parágrafos.
- **Estilização de Rótulos:** Ajustados os rótulos para `FontWeight.Medium`, melhorando a hierarquia visual sem sobrecarregar a interface com negritos pesados.

## Resultado esperado
- Os textos digitados agora aparecem centralizados verticalmente e totalmente visíveis, sem cortes nas letras "g", "j", "p", "q" ou "y".
- O contraste entre o texto preto e o fundo branco dos campos garante que qualquer agricultor consiga ler o que está escrevendo com clareza.
- A interface mantém o padrão visual organizado e responsivo do AgroAjuda.
