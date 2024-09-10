package src.test.java.com.resistorcolorcode.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResistorColorServiceTest {
    private final ResistorColorService resistorColorService = new ResistorColorService();

    @Test
    public void testConvertOhmsToColorCode_47Ohms() {
        String result = resistorColorService.convertOhmsToColorCode("47 ohms");
        assertEquals("amarelo violeta preto dourado", result);
    }

    @Test
    public void testConvertOhmsToColorCode_4k7Ohms() {
        String result = resistorColorService.convertOhmsToColorCode("4.7k ohms");
        assertEquals("amarelo violeta vermelho dourado", result);
    }

    @Test
    public void testConvertOhmsToColorCode_1MOhms() {
        String result = resistorColorService.convertOhmsToColorCode("1M ohms");
        assertEquals("marrom preto verde dourado", result);
    }

    @Test
    public void testConvertOhmsToColorCode_InvalidInput_NoOhms() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> resistorColorService.convertOhmsToColorCode("47")
        );
        assertEquals("Formato inválido. Certifique-se de incluir 'ohms'.", exception.getMessage());
    }

    @Test
    public void testConvertOhmsToColorCode_OutOfRange_TooLow() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> resistorColorService.convertOhmsToColorCode("5 ohms")
        );
        assertEquals("Valor de resistência fora do intervalo suportado.", exception.getMessage());
    }

    @Test
    public void testConvertOhmsToColorCode_OutOfRange_TooHigh() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> resistorColorService.convertOhmsToColorCode("100M ohms")
        );
        assertEquals("Valor de resistência fora do intervalo suportado.", exception.getMessage());
    }
}
