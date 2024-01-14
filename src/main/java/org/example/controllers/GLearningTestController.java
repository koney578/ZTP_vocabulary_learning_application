package org.example.controllers;

import org.example.Word;
import org.example.views.GLearningTestView;

import java.util.List;

public class GLearningTestController extends GController{
    private GLearningTestView gLearningTestView;
    private GMenuController gMenuController;

    public GLearningTestController(GMenuController gMenuController) {
        gLearningTestView = new GLearningTestView(this, jframe);
        this.gMenuController = gMenuController;
    }

    public void run() {
        gLearningTestView.show();
    }

    public void getNewMenuView() {
        gMenuController.run();
    }

    public String getWords() {
        List<Word> words = wordDispenser.getState().getWords();
        String wordsString = "";
        for (Word word : words) {
            wordsString = wordsString + " "+ word.getPolishWord();
        }
        return wordsString;
    }
}
