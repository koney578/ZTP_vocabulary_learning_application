package org.example.controllers;

import org.example.views.GLoginRegisterView;
import org.example.views.GMenuView;

public class GMenuController extends GController{

    private GMenuView gMenuView;
    private GLoginController gLoginController;
    public GMenuController(GLoginController gLoginController) {
        gMenuView = new GMenuView(this, jframe);
        this.gLoginController = gLoginController;
    }

    public void run() {
        gMenuView.show();
    }
}
