package org.example.state;

import org.example.Word;

import java.util.List;

public class TestState extends State{
    TestState(WordDispenser wordDispenser) {
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
        return wordDispenser.getWordsStrategy2();
    }
}
