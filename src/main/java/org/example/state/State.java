package org.example.state;

public abstract class State {
    WordDispenser wordDispenser;
    State(WordDispenser wordDispenser) {
        this.wordDispenser = wordDispenser;
    }

    public abstract String onLock();
}
