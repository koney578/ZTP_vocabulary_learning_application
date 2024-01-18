package org.example.decorator;

import org.example.Word;

import java.util.Collections;
import java.util.List;

public class WordsMixerDecorator extends WordsDecorator{
    public WordsMixerDecorator(WordEditor wordEditor) {
        super(wordEditor);
    }

    @Override
    public List<Word> decorateWords() {
        return mixWords(super.decorateWords());
    }

    public List<Word> mixWords(List<Word> words){
        Collections.shuffle(words);
        return words;
    }
}
