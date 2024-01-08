package org.example.controllers;

import org.example.views.GMenuView;

public class GMenuController extends GController{

    private GMenuView gMenuView;
    private GLoginController gLoginController;
    private GLoginRegisterController gLoginRegisterController;
    public GMenuController(GLoginController gLoginController, GLoginRegisterController gLoginRegisterController) {
        gMenuView = new GMenuView(this, jframe);
        this.gLoginController = gLoginController;
        this.gLoginRegisterController = gLoginRegisterController;
    }

    public void run() {
        gMenuView.show();
    }

    public void getNewLoginRegisterView() {
        gLoginRegisterController.run();
    }
}
