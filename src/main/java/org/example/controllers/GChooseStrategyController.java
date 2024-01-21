package org.example.controllers;

import org.example.views.GChooseStrategyView;
import org.example.views.GMenuView;

public class GChooseStrategyController extends GController{
    private GChooseStrategyView gChooseStrategyView;
    private GMenuController gMenuController;
    private GLearningTestController gLearningTestController;
    public boolean isMixed = false;
    public GChooseStrategyController(GMenuController gMenuController) {
        gChooseStrategyView = new GChooseStrategyView(this, jframe);
        this.gMenuController = gMenuController;
        this.gLearningTestController = new GLearningTestController(this,gMenuController);
    }

    public void run() {
        gChooseStrategyView.show();
    }

    public void getNewLearningTestView() {
        gLearningTestController.run();
    }

    public void getNewMenuView() {
        gMenuController.run();
    }


    public void setStrategy(int number) {
        wordDispenser.setStrategy(number);
    }

    public void setMixed(boolean flaque){
        isMixed = flaque;
    }

    public boolean getMixed(){
        return isMixed;
    }
}
