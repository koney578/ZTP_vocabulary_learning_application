package org.example.decorator;

import org.example.Word;

import java.util.List;

public class WordsDecorator implements WordEditor {

    private WordEditor wordEditor;

    public WordsDecorator(WordEditor wordEditor){
        this.wordEditor = wordEditor;
    }

    @Override
    public List<Word> decorateWords() {
        return wordEditor.decorateWords();
    }
}
