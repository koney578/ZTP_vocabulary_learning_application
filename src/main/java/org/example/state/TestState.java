package org.example.state;

public class TestState extends State{
    TestState(WordDispenser wordDispenser) {
        super(wordDispenser);
    }
    @Override
    public String onLock() {
        wordDispenser.changeState(new LearningState(wordDispenser));
        return "Start learning";
    }
}
