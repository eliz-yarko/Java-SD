package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Word {
    private List<Letter> letters;

    public Word(String word) {
        letters = word.chars().mapToObj(c -> new Letter((char) c)).collect(Collectors.toList());
    }

    public String getWord() {
        return letters.stream().map(Letter::toString).collect(Collectors.joining());
    }

    @Override
    public String toString() {
        return getWord();
    }
}
