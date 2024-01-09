package org.example.state;

public class LearningState extends State{
    public LearningState(WordDispenser wordDispenser) {
        super(wordDispenser);
    }
    @Override
    public String onLock() {
        wordDispenser.changeState(new TestState(wordDispenser));
        return "Start test";
    }
}
