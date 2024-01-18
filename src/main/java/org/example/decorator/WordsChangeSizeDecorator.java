package org.example.decorator;

import org.example.Word;

import java.util.ArrayList;
import java.util.List;

public class WordsChangeSizeDecorator extends WordsDecorator{
    public WordsChangeSizeDecorator(WordEditor wordEditor) {
        super(wordEditor);
    }

    @Override
    public List<Word> decorateWords() {
        return changeSizeLetter(super.decorateWords());
    }

    private List<Word> changeSizeLetter(List<Word> words) {
        List<Word> wordsChangedSizeLetter = new ArrayList<>();
        for(Word word: words){
            String word1 = word.getPolishWord().toUpperCase();
            String word2 = word.getEnglishWord().toUpperCase();
            Word word3 = new Word(word1, word2);
            wordsChangedSizeLetter.add(word3);
        }
        return wordsChangedSizeLetter;
    }
}
