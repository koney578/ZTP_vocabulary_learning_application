package org.example.controllers;


import org.example.views.GLoginRegisterView;

public class GLoginRegisterController extends GController {
    private GLoginRegisterView gLoginRegisterView;
    private GLoginController gLoginController;
    private GRegisterController gRegisterController;

    public GLoginRegisterController() {
        gLoginRegisterView = new GLoginRegisterView(this, jframe);
        gLoginController = new GLoginController(this);
        gRegisterController = new GRegisterController(this, gLoginController);
    }

    public void run() {
        gLoginRegisterView.show();
    }

    public void getNewLoginView() {
        gLoginController.run();
    }

    public void getNewRegisterView() {
        gRegisterController.run();
    }


    public static void exitApp() {
        GController.exitApp();
    }
}
