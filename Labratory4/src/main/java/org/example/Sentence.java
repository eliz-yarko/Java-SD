package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Sentence {
    private List<Word> words;

    public Sentence(String sentence) {
        words = Arrays.stream(sentence.split("\\s+")).map(Word::new).collect(Collectors.toList());
    }

    public List<Word> getWords() {
        return words;
    }

    public int getWordCount() {
        return words.size();
    }

    @Override
    public String toString() {
        return words.stream().map(Word::toString).collect(Collectors.joining(" "));
    }
}
