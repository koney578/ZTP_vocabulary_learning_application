package org.example.builder;

import java.util.Random;

public class SameLettersWordBuilder implements WordBuilder {
    private StringBuilder resultWord;

    @Override
    public void buildWord(String word) {
        char[] shuffledLetters = word.toCharArray();
        Random random = new Random();
        for (int i = shuffledLetters.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            char temp = shuffledLetters[index];
            shuffledLetters[index] = shuffledLetters[i];
            shuffledLetters[i] = temp;
        }
        resultWord = new StringBuilder().append(shuffledLetters);
    }

    @Override
    public ResultWord getResult() {
        return new ResultWord(resultWord.toString());
    }
}
