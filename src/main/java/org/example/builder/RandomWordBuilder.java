package org.example.builder;

import java.util.Random;
public class RandomWordBuilder implements WordBuilder {
    private StringBuilder resultWord;

    @Override
    public void buildWord(String word) {
        Random random = new Random();
        resultWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char randomChar = (char) (random.nextInt(26) + 'a');
            resultWord.append(randomChar);
        }
    }

    @Override
    public ResultWord getResult() {
        return new ResultWord(resultWord.toString());
    }
}
