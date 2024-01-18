package org.example.builder;
public class Director {
    public void constructWord(WordBuilder wordBuilder, String word) {
        wordBuilder.buildWord(word);
    }
}
