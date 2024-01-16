package org.example.controllers;

import org.example.User;
import org.example.views.GMenuView;

public class GMenuController extends GController{

    private GMenuView gMenuView;
    private GLoginController gLoginController;
    private GLoginRegisterController gLoginRegisterController;

    private GChooseStrategyController gChooseStrategyController;
    private GLearningTestController gLearningTestController;
    public GMenuController(GLoginController gLoginController, GLoginRegisterController gLoginRegisterController) {
        gMenuView = new GMenuView(this, jframe);
        this.gLoginController = gLoginController;
        this.gLoginRegisterController = gLoginRegisterController;
        this.gChooseStrategyController = new GChooseStrategyController(this);
//        this.gLearningTestController = new GLearningTestController(this);
    }

    public void run() {
        gMenuView.show();
    }

    public void getNewLoginRegisterView() {
        gLoginRegisterController.run();
    }

//    public void getNewLearningTestView() {
//        gLearningTestController.run();
//    }

    public void getNewChooseStrategyView() {
        gChooseStrategyController.run();
    }
    public void setStateTest() {
        wordDispenser.getState().setTest();
    }
    public void setStateLearning() {
        wordDispenser.getState().setLearning();
    }

    public String getName(){
        User user = GController.getLoggedUser();
        return user.getName();
    }

    public void setEnglishMode(boolean flague) {
        englishMode = flague;
    }
}
