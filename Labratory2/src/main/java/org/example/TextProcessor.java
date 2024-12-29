package org.example;
import java.util.*;
import java.util.stream.Collectors;

class TextProcessor {
    public void findSentencesWithCommonWords(CharSequence text) {
        String[] sentences = text.toString().split("[.!?]");
        Map<String, Integer> wordCount = new HashMap<>();
        int maxCount = 0;

        for (String sentence : sentences) {
            Set<String> words = new HashSet<>(Arrays.asList(sentence.split("\\s+")));
            for (String word : words) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                maxCount = Math.max(maxCount, wordCount.get(word));
            }
        }

        System.out.println("Max sentences with common words: " + maxCount);
    }

    public void sortSentencesByWordCount(CharSequence text) {
        String[] sentences = text.toString().split("[.!?]");
        Arrays.sort(sentences, Comparator.comparingInt(s -> s.split("\\s+").length));
        System.out.println("Sorted sentences: " + Arrays.toString(sentences));
    }

    public void findUniqueWordInFirstSentence(CharSequence text) {
        String[] sentences = text.toString().split("[.!?]");
        Set<String> firstSentenceWords = new HashSet<>(Arrays.asList(sentences[0].split("\\s+")));
        Set<String> otherWords = new HashSet<>();

        for (int i = 1; i < sentences.length; i++) {
            otherWords.addAll(Arrays.asList(sentences[i].split("\\s+")));
        }

        firstSentenceWords.removeAll(otherWords);
        System.out.println("Unique word: " + firstSentenceWords);
    }

    public void findWordsOfLengthInQuestions(CharSequence text, int length) {
        String[] sentences = text.toString().split("[.!?]");
        Set<String> words = new HashSet<>();

        for (String sentence : sentences) {
            if (sentence.contains("?")) {
                for (String word : sentence.split("\\s+")) {
                    if (word.length() == length) words.add(word);
                }
            }
        }
        System.out.println("Words in questions: " + words);
    }

    public void swapFirstAndLastWords(CharSequence text) {
        String[] sentences = text.toString().split("[.!?]");
        for (String sentence : sentences) {
            String[] words = sentence.split("\\s+");
            if (words.length > 1) {
                String temp = words[0];
                words[0] = words[words.length - 1];
                words[words.length - 1] = temp;
            }
            System.out.println("Modified sentence: " + String.join(" ", words));
        }
    }

    public void printUniqueWordsAlphabetically(CharSequence text) {
        Set<String> words = new TreeSet<>(Arrays.asList(text.toString().split("\\s+")));
        System.out.println("Unique words: " + words);
    }

    public void sortWordsByVowelCount(CharSequence text) {
        List<String> words = Arrays.asList(text.toString().split("\\s+"));
        words.sort(Comparator.comparingInt(this::countVowels));
        System.out.println("Sorted by vowels: " + words);
    }

    private int countVowels(String word) {
        return (int) word.chars().filter(c -> "aeiouAEIOU".indexOf(c) != -1).count();
    }

    public void sortWordsBySpecificLetterCount(CharSequence text, char letter) {
        List<String> words = Arrays.asList(text.toString().split("\\s+"));
        words.sort(Comparator.comparingInt(w -> Collections.frequency(Arrays.asList(w.split("")), String.valueOf(letter))));
        System.out.println("Sorted by letter '" + letter + "': " + words);
    }

    public void sortWordsStartingWithVowels(CharSequence text) {
        List<String> words = Arrays.stream(text.toString().split("\\s+"))
                .filter(word -> word.length() > 1 && "aeiouAEIOU".indexOf(word.charAt(0)) != -1)
                .sorted(Comparator.comparing(word -> word.charAt(1)))
                .collect(Collectors.toList());
        System.out.println("Words starting with vowels sorted by second letter: " + words);
    }

    public void countSentencesContainingWords(CharSequence text, String[] words) {
        String[] sentences = text.toString().split("[.!?]");
        Map<String, Integer> wordCounts = new HashMap<>();

        for (String word : words) {
            int count = 0;
            for (String sentence : sentences) {
                if (Arrays.asList(sentence.split("\\s+")).contains(word)) {
                    count++;
                }
            }
            wordCounts.put(word, count);
        }

        System.out.println("Word occurrences in sentences: " + wordCounts);
    }

    public void removeLongestSubstringBetweenChars(CharSequence text, char start, char end) {
        String result = text.toString().replaceAll(start + ".*?" + end, "");
        System.out.println("Text after removing longest substring: " + result);
    }
    public void removeWordsOfLengthStartingWithConsonant(CharSequence text, int length) {
        String result = Arrays.stream(text.toString().split("\\s+"))
                .filter(word -> !(word.length() == length && "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(word.charAt(0)) != -1))
                .collect(Collectors.joining(" "));
        System.out.println("Text after removing words: " + result);
    }
    public void sortWordsBySpecificLetterOccurrences(CharSequence text, char letter) {
        List<String> words = Arrays.asList(text.toString().split("\\s+"));
        words.sort(Comparator.comparingInt(word -> word.length() - word.replace(String.valueOf(letter), "").length()));
        System.out.println("Words sorted by occurrences of '" + letter + "': " + words);
    }

    public void findLongestPalindromeSubstring(CharSequence text) {
        String str = text.toString();
        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String sub = str.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        System.out.println("Longest palindrome substring: " + longest);
    }

    private boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public void removeFollowingFirstLetterOccurrences(CharSequence text) {
        String result = Arrays.stream(text.toString().split("\\s+"))
                .map(word -> word.charAt(0) + word.substring(1).replaceAll(String.valueOf(word.charAt(0)), ""))
                .collect(Collectors.joining(" "));
        System.out.println("Text after removing following first letters: " + result);
    }

    public void replaceWordsOfLengthWithText(CharSequence text, int length, String replacement) {
        String result = Arrays.stream(text.toString().split("\\s+"))
                .map(word -> word.length() == length ? replacement : word)
                .collect(Collectors.joining(" "));
        System.out.println("Text after replacing words: " + result);
    }

    public void removePreviousLastLetterOccurrences(CharSequence text) {
        String result = Arrays.stream(text.toString().split("\\s+"))
                .map(word -> word.replaceAll("." + word.charAt(word.length() - 1) + "$", ""))
                .collect(Collectors.joining(" "));
        System.out.println("Text after removing previous last letters: " + result);
    }
}
