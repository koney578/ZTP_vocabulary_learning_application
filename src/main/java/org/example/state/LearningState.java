package org.example.state;

import org.example.Word;

import java.util.List;

public class LearningState extends State{
    public LearningState(WordDispenser wordDispenser) {
        super(wordDispenser);
    }
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
        return wordDispenser.getWordsStrategy1();
    }
}
