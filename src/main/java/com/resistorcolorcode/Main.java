package src.main.java.com.resistorcolorcode;

import src.main.java.com.resistorcolorcode.service.ResistorColorService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ResistorColorService resistorColorService = new ResistorColorService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor do resistor (Exemplo: 4.7k ohms ou 47 ohms):");
        String input = scanner.nextLine();

        try {
            String colorCode = resistorColorService.convertOhmsToColorCode(input);
            System.out.println("O código de cores do resistor é: " + colorCode);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
