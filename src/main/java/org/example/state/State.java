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

    public abstract Word getGoodWord();

    public abstract String getMessage();

    public abstract String checkAnswer(Word word);

    public abstract String getPoints();

    public abstract int checkQuestion();

    public abstract void removeWordFamiliarized();

    public abstract void refreshWordFamiliarized();

    public abstract String checkWordEnglish(String wordEnglish);

    public abstract String checkWordPolish(String wordPolish);

    public abstract String howState();
}
