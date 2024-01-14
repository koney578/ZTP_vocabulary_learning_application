package org.example.state;

import org.example.Word;
import org.example.strategy.Difficulty1;
import org.example.strategy.Difficulty2;

import java.util.List;

public class WordDispenser {
    private State state;
    public WordDispenser() {
        this.state = new LearningState(this);
    }

    public void changeState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }
    public List<Word> getWordsStrategy1() {
        Difficulty1 difficulty1 = new Difficulty1();
        return difficulty1.downloadWords();
    }
    public List<Word> getWordsStrategy2() {
        Difficulty2 difficulty2 = new Difficulty2();
        return difficulty2.downloadWords();
    }
}
