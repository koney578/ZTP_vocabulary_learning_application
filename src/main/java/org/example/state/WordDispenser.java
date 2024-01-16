package org.example.state;

import org.example.Database;
import org.example.IConnection;
import org.example.Word;
import org.example.strategy.*;

import java.util.List;

public class WordDispenser {
    private State state;
    private DifficultyStrategy difficultyStrategy;
    public WordDispenser() {
        this.state = new LearningState(this);
    }
    public void changeState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }

    public void setStrategy(int number) {
        if (number == 1){
            difficultyStrategy = new Difficulty1();
        }
        else if(number == 2){
            difficultyStrategy = new Difficulty2();
        }
        else if(number == 3){
            difficultyStrategy = new Difficulty3();
        }
        else if(number == 4){
            difficultyStrategy = new Difficulty4();
        }
        else if(number == 5){
            difficultyStrategy = new Difficulty5();
        }
    }
    public List<Word> getWords() {
        return difficultyStrategy.downloadWords();
    }
}
