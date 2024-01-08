package org.example.controllers;


import org.example.views.GLoginRegisterView;

public class GLoginRegisterController extends GController {
    private GLoginRegisterView gLoginRegisterView;
    private GLoginController gLoginController;

    public GLoginRegisterController() {
        gLoginRegisterView = new GLoginRegisterView(this, jframe);
        gLoginController = new GLoginController(this);

    }

    public void run() {
        gLoginRegisterView.show();
    }

    public void getNewLoginView() {
        gLoginController.run();
    }


    public static void exitApp() {
        GController.exitApp();
    }
}
