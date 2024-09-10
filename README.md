# Resistor Color Code Converter

Este projeto converte valores de resistência de resistores para o código de cores correspondente, utilizando as bandas de cores padrão dos resistores.

## Descrição

O serviço `ResistorColorService` recebe uma string que representa o valor de um resistor em ohms, kilohms ou megaohms (por exemplo, "47 ohms", "4.7k ohms", "1M ohms") e retorna o código de cores correspondente para esse valor de resistência.

O código de cores é exibido como uma string de cores separadas por espaço. O valor de resistência deve ser fornecido no formato correto, incluindo a unidade `ohms`.

## Funcionalidades

- Converte valores de resistência como "47 ohms", "4.7k ohms", "1M ohms" para o código de cores correspondente.
- Suporta resistores de 4 bandas (3 bandas de valor + 1 banda de tolerância).
- Lança exceções para valores de resistência fora do intervalo suportado ou para entradas mal formatadas.

## Pré-requisitos

- **Java 11+**
- **Maven ou Gradle** (se você quiser rodar o projeto e os testes com uma dessas ferramentas).

## Como usar

Você pode usar o serviço `ResistorColorService` diretamente no seu código Java.

### Exemplo de uso:

```java
public class Main {
    public static void main(String[] args) {
        ResistorColorService resistorColorService = new ResistorColorService();
        
        String colorCode = resistorColorService.convertOhmsToColorCode("47 ohms");
        System.out.println("Código de cores: " + colorCode);
    }
}
