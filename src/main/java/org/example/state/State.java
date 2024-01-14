package org.example.state;

import org.example.Word;

import java.util.List;

public abstract class State {
    WordDispenser wordDispenser;
    State(WordDispenser wordDispenser) {
        this.wordDispenser = wordDispenser;
    }

    public abstract String setTest();

    public abstract String setLearning();
    public abstract List<Word> getWords();
}
