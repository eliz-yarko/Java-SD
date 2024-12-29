package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class Text {
    private List<Sentence> sentences;

    public Text(String text) {
        sentences = Arrays.stream(text.split("(?<=[.!?])\\s+"))
                .map(Sentence::new).collect(Collectors.toList());
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return sentences.stream().map(Sentence::toString).collect(Collectors.joining(" "));
    }
}
