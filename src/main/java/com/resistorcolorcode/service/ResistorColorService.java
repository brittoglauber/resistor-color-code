package src.main.java.com.resistorcolorcode.service;

import java.util.HashMap;
import java.util.Map;

public class ResistorColorService {
    private static final Map<Integer, String> COLOR_MAP = new HashMap<>();
    private static final String TOLERANCE_COLOR = "dourado";

    static {
        COLOR_MAP.put(0, "preto");
        COLOR_MAP.put(1, "marrom");
        COLOR_MAP.put(2, "vermelho");
        COLOR_MAP.put(3, "laranja");
        COLOR_MAP.put(4, "amarelo");
        COLOR_MAP.put(5, "verde");
        COLOR_MAP.put(6, "azul");
        COLOR_MAP.put(7, "violeta");
        COLOR_MAP.put(8, "cinza");
        COLOR_MAP.put(9, "branco");
    }

    /**
     * Converte um valor de ohms em uma string com as cores correspondentes
     * @param input String com o valor do resistor (ex: "4.7k ohms")
     * @return Código de cores do resistor
     * @throws IllegalArgumentException se o formato de entrada for inválido
     */
    public String convertOhmsToColorCode(String input) throws IllegalArgumentException {
        if (!input.toLowerCase().contains("ohms")) {
            throw new IllegalArgumentException("Formato inválido. Certifique-se de incluir 'ohms'.");
        }

        String valuePart = input.replace("ohms", "").trim().toLowerCase();

        double value;
        int multiplier;

        if (valuePart.endsWith("k")) {
            value = Double.parseDouble(valuePart.replace("k", ""));
            multiplier = 1_000;
        } else if (valuePart.endsWith("m")) {
            value = Double.parseDouble(valuePart.replace("m", ""));
            multiplier = 1_000_000;
        } else {
            value = Double.parseDouble(valuePart);
            multiplier = 1;
        }

        int resistanceValue = (int) (value * multiplier);

        System.out.println(resistanceValue);

        if (resistanceValue < 10 || resistanceValue > 99_000_000) {
            throw new IllegalArgumentException("Valor de resistência fora do intervalo suportado.");
        }

        return getColorCode(resistanceValue);
    }

    /**
     * Retorna a sequência de cores para o valor de resistência
     * @param resistance Valor de resistência em ohms
     * @return Sequência de cores
     */
    private String getColorCode(int resistance) {
        StringBuilder colorCode = new StringBuilder();

        int firstDigit = (resistance / (int) Math.pow(10, getNumberOfDigits(resistance) - 1)) % 10;
        int secondDigit = (resistance / (int) Math.pow(10, getNumberOfDigits(resistance) - 2)) % 10;
        int multiplier = getNumberOfDigits(resistance) - 2;

        colorCode.append(COLOR_MAP.get(firstDigit)).append(" ");
        colorCode.append(COLOR_MAP.get(secondDigit)).append(" ");
        colorCode.append(COLOR_MAP.get(multiplier)).append(" ");
        colorCode.append(TOLERANCE_COLOR);

        return colorCode.toString();
    }


    /**
     * Retorna o número de dígitos em um valor de resistência
     * @param resistance Valor de resistência
     * @return Número de dígitos
     */
    private int getNumberOfDigits(int resistance) {
        return String.valueOf(resistance).length();
    }
}
