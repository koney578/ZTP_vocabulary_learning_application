package org.example.state;

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
}
