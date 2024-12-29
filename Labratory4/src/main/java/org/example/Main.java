package org.example;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputText;
        while (true) {
            // Введення тексту з консолі
            System.out.println("Enter the text:");
            inputText = scanner.nextLine();
            if (inputText.trim().isEmpty()) {
                System.out.println("Error: The text cannot be empty! Please try again.");
            } else {
                break;
            }
        }

        char targetChar;
        while (true) {
            // Введення символу для підрахунку
            System.out.println("Enter the character to count:");
            String inputChar = scanner.nextLine();
            if (inputChar.isEmpty()) {
                System.out.println("Error: No character entered! Please try again.");
                continue;
            }
            targetChar = Character.toLowerCase(inputChar.charAt(0));

            // Перевірка чи символ є літерою
            if (!Character.isLetter(targetChar)) {
                System.out.println("Error: Please enter a valid letter! Try again.");
            } else {
                break;
            }
        }

        // Створення тексту
        Text text = new Text(inputText.replaceAll("[\t\n\r ]+", " "));
        System.out.println("Initial text:");
        System.out.println(text);

        // Нормалізація регістру тексту
        final char normalizedTargetChar = Character.toLowerCase(targetChar);
        List<Word> allWords = text.getSentences().stream()
                .flatMap(sentence -> sentence.getWords().stream())
                .collect(Collectors.toList());

        allWords = allWords.stream()
                .sorted(Comparator.comparingInt(word ->
                        (int) word.getWord().toLowerCase().chars().filter(ch -> ch == normalizedTargetChar).count()))
                .collect(Collectors.toList());

        System.out.println("\nWords sorted by occurrences of letter '" + normalizedTargetChar + "':");
        allWords.forEach(word -> System.out.println(word + " (count: " +
                word.getWord().toLowerCase().chars().filter(ch -> ch == normalizedTargetChar).count() + ")"));
    }
}