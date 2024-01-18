package org.example.decorator;

import org.example.Word;

import java.util.List;

public class WordEditorBasic implements WordEditor{

    private List<Word> words;

    public WordEditorBasic(List<Word> words){
        this.words = words;
    }

    @Override
    public List<Word> decorateWords() {
        return words;
    }
}
