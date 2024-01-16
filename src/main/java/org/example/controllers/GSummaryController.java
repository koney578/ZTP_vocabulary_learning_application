package org.example.controllers;

import org.example.views.GMenuView;
import org.example.views.GSummaryView;

public class GSummaryController extends GController{
    private GSummaryView gSummaryView;
    private GMenuController gMenuController;
    private GLearningTestController gLearningTestController;
    public GSummaryController(GMenuController gMenuController, GLearningTestController gLearningTestController) {
        gSummaryView = new GSummaryView(this, jframe);
        this.gMenuController = gMenuController;
        this.gLearningTestController = gLearningTestController;
    }
    public void run() {
        gSummaryView.show();
    }

    public String getResult() {
        return wordDispenser.getState().getPoints();
    }

    public void getNewMenuView() {
        gMenuController.run();
    }
}
