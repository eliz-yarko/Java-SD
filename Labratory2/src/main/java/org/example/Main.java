package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Введення номера залікової книжки
            System.out.print("Enter student ID: ");
            int studentID = scanner.nextInt();

            // Обчислення C3 та C17
            int C3 = studentID % 3;
            int C17 = studentID % 17;

            // Виведення значень для перевірки
            System.out.println("Student ID: " + studentID);
            System.out.println("C3: " + C3);
            System.out.println("C17: " + C17);

            // Введення тексту
            scanner.nextLine(); // Очищення буфера
            System.out.print("Enter text: ");
            String inputText = scanner.nextLine();

            // Визначення типу текстової змінної
            CharSequence text;
            switch (C3) {
                case 0 -> text = new StringBuilder(inputText);
                case 1 -> text = inputText;
                case 2 -> text = new StringBuffer(inputText);
                default -> throw new IllegalStateException("Unexpected value: " + C3);
            }

            // Виведення початкового тексту
            System.out.println("Initial text: " + text);

            // Виконання дії з текстом відповідно до C17
            TextProcessor processor = new TextProcessor();
            switch (C17) {
                case 0 -> processor.findSentencesWithCommonWords(text);
                case 1 -> processor.sortSentencesByWordCount(text);
                case 2 -> processor.findUniqueWordInFirstSentence(text);
                case 3 -> {
                    System.out.print("Enter word length: ");
                    int length = scanner.nextInt();
                    processor.findWordsOfLengthInQuestions(text, length);
                }
                case 4 -> processor.swapFirstAndLastWords(text);
                case 5 -> processor.printUniqueWordsAlphabetically(text);
                case 6 -> processor.sortWordsByVowelCount(text);
                case 7 -> processor.sortWordsStartingWithVowels(text);
                case 8 -> {
                    System.out.print("Enter letter to count: ");
                    char letter = scanner.next().charAt(0);
                    processor.sortWordsBySpecificLetterCount(text, letter);
                }
                case 9 -> {
                    System.out.print("Enter words to search (comma separated): ");
                    String[] words = scanner.nextLine().split(",");
                    processor.countSentencesContainingWords(text, words);
                }
                case 10 -> {
                    System.out.print("Enter start and end characters: ");
                    char start = scanner.next().charAt(0);
                    char end = scanner.next().charAt(0);
                    processor.removeLongestSubstringBetweenChars(text, start, end);
                }
                case 11 -> {
                    System.out.print("Enter word length: ");
                    int length = scanner.nextInt();
                    processor.removeWordsOfLengthStartingWithConsonant(text, length);
                }
                case 12 -> {
                    System.out.print("Enter letter to count: ");
                    char letter = scanner.next().charAt(0);
                    processor.sortWordsBySpecificLetterOccurrences(text, letter);
                }
                case 13 -> processor.findLongestPalindromeSubstring(text);
                case 14 -> processor.removeFollowingFirstLetterOccurrences(text);
                case 15 -> {
                    System.out.print("Enter word length and replacement text: ");
                    int length = scanner.nextInt();
                    scanner.nextLine(); // Очищення буфера
                    String replacement = scanner.nextLine();
                    processor.replaceWordsOfLengthWithText(text, length, replacement);
                }
                case 16 -> processor.removePreviousLastLetterOccurrences(text);
                default -> throw new IllegalStateException("Unexpected value: " + C17);
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}