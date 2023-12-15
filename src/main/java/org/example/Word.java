package org.example;

public class Word {
    private static int idGenerate = 0;
    private int id;
    private String[] polishWord;
    private String[] englishWord;
    public Word(String[] polishWord, String[] englishWord){
        idGenerate = idGenerate + 1;
        this.id = idGenerate;
        this.polishWord = polishWord;
        this.englishWord = englishWord;
    }
}

