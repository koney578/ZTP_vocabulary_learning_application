package org.example.state;

import org.example.Database;
import org.example.IConnection;
import org.example.Word;

import java.util.List;

public class TestState extends State{
    TestState(WordDispenser wordDispenser) {
        super(wordDispenser);
    }
    private Word goodWord;
    private int points = 0;
    private int question = 0;

    @Override
    public String setTest() {
        wordDispenser.changeState(new TestState(wordDispenser));
        return "Ustawiono Stan Test";
    }
    @Override
    public String setLearning() {
        wordDispenser.changeState(new LearningState(wordDispenser));
        return "Ustawiono Stan Learning";
    }

    @Override
    public List<Word> getWords() {
        List<Word> words;
        IConnection connection = Database.getConnection();
        Word randomWord = connection.getRandomWord();

        while(true){
            boolean flague = true;
            words = wordDispenser.getWords();
            for(Word word: words){
                if(word.getPolishWord().equals(randomWord.getPolishWord())){
                    words = wordDispenser.getWords();
                    flague = false;
                }
            }
            if (flague){
                break;
            }
        }
        goodWord = randomWord;
        if (words.size() != 0) {
            words.add(randomWord);
        }
        return words;
    }
    @Override
    public Word getGoodWord() {
        return goodWord;
    }
    @Override
    public String getMessage() {
        return "Aktualnie znajdujesz się w trybie testu...";
    }

    @Override
    public String checkAnswer(Word word) {
        if (word.getPolishWord().equals(goodWord.getPolishWord())) {
            points = points + 1;
        }
        question = question + 1;
        return "next";
    }
    @Override
    public String getPoints(){
        return String.valueOf(points);
    }
    @Override
    public int checkQuestion() {
        return question;
    }

    @Override
    public void removeWordFamiliarized() {
        IConnection connection = Database.getConnection();
        List<Word> words = connection.getWordsFamiliarized();
        for (Word word: words){
            if(word.getPolishWord().equals(goodWord.getPolishWord())){
                connection.removeWordFamiliarized(word);
                break;
            }
        }
    }

    @Override
    public void refreshWordFamiliarized() {
        IConnection connection = Database.getConnection();
        connection.refreshWordFamiliarized();
    }
}
