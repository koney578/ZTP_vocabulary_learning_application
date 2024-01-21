package org.example.controllers;

import org.example.Word;
import org.example.views.GLearningTestView;

import java.util.List;
import java.util.Random;

public class GLearningTestController extends GController{
    private GSummaryController gSummaryController;
    private GLearningTestView gLearningTestView;
    private GMenuController gMenuController;
    private GChooseStrategyController gChooseStrategyController;

    public GLearningTestController(GChooseStrategyController gChooseStrategyController, GMenuController gMenuController) {
        gLearningTestView = new GLearningTestView(this, jframe);
        this.gMenuController = gMenuController;
        this.gSummaryController = new GSummaryController(gMenuController, this);
        this.gChooseStrategyController = gChooseStrategyController;
    }

    public void run() {
        if(gChooseStrategyController.getMixed()){
            Random random = new Random();
            int liczbaLosowa = random.nextInt(5) + 1;
            gChooseStrategyController.setStrategy(liczbaLosowa);
        }
        gLearningTestView.show();
    }

    public void getNewMenuView() {
        gMenuController.run();
    }
    public void getNewSummaryView() {
        gSummaryController.run();
    }

    public List<Word> getWords() {
        List<Word> words = wordDispenser.getState().getWords();
        return words;
    }

    public String getMessage() {
        return wordDispenser.getState().getMessage();
    }

    public boolean getMode() {
        return englishMode;
    }

    public Word getWord() {
        return wordDispenser.getState().getGoodWord();
    }

    public String checkAnswer(Word word) {
        return wordDispenser.getState().checkAnswer(word);
    }

    public int checkQuestion() {
        return wordDispenser.getState().checkQuestion();
    }

    public void removeWordFamilirized() {
        wordDispenser.getState().removeWordFamiliarized();
    }

    public void refreshWordFamiliarized() {
        wordDispenser.getState().refreshWordFamiliarized();
    }

    public String checkWordEnglish(String wordEnglish) {
        return wordDispenser.getState().checkWordEnglish(wordEnglish);
    }

    public String checkWordPolish(String wordPolish) {
        return wordDispenser.getState().checkWordPolish(wordPolish);
    }

    public String howState() {
        return wordDispenser.getState().howState();
    }
}