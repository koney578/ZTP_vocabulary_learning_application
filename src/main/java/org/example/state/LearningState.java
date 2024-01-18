package org.example.state;

import org.example.Database;
import org.example.IConnection;
import org.example.Word;
import org.example.builder.Director;
import org.example.builder.RandomWordBuilder;
import org.example.builder.ResultWord;
import org.example.decorator.WordEditorBasic;
import org.example.decorator.WordsChangeSizeDecorator;
import org.example.decorator.WordsDecorator;
import org.example.decorator.WordsMixerDecorator;

import java.util.List;

public class LearningState extends State{
    public LearningState(WordDispenser wordDispenser) {
        super(wordDispenser);
    }
    private Word goodWord;

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
            Director director = new Director();
            RandomWordBuilder randomWordBuilder = new RandomWordBuilder();

            director.constructWord(randomWordBuilder, words.get(0).getPolishWord());
            ResultWord builderWord = randomWordBuilder.getResult();
            String polish = builderWord.getValue();

            director.constructWord(randomWordBuilder, words.get(0).getEnglishWord());
            ResultWord builderWord1 = randomWordBuilder.getResult();
            String english = builderWord1.getValue();
            Word wordBuilded = new Word(polish,english);
            words.set(0,wordBuilded);

            words.add(randomWord);
        }

        WordsDecorator wordsDecoratorMixed = new WordsMixerDecorator(new WordEditorBasic(words));
        WordsDecorator wordsDecoratorSize = new WordsChangeSizeDecorator(new WordEditorBasic(wordsDecoratorMixed.decorateWords()));

        return wordsDecoratorSize.decorateWords();
    }
    @Override
    public Word getGoodWord() {
        return goodWord;
    }

    @Override
    public String getMessage() {
        return "Aktualnie znajdujesz się trybie nauki...";
    }
    @Override
    public String checkAnswer(Word word) {
        String word1 = word.getPolishWord().toLowerCase();
        if (word1.equals(goodWord.getPolishWord())) {
            question = question + 1;
            return "go";
        }
        else{
            return "stop";
        }
    }

    @Override
    public String getPoints() {
        return "Nauka nie jest punktowana";
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

    @Override
    public String checkWordEnglish(String wordEnglish) {
        String word = wordEnglish.toLowerCase();
        if (goodWord.getEnglishWord().equals(word)){
            question = question + 1;
            return "go";
        }
        return "stop";
    }

    @Override
    public String checkWordPolish(String wordPolish) {
        String word = wordPolish.toLowerCase();
        if (goodWord.getPolishWord().equals(word)){
            question = question + 1;
            return "go";
        }
        return "stop";
    }
}
