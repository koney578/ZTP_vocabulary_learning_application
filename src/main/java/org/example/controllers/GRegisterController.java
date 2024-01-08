package org.example.controllers;

import org.example.Database;
import org.example.IConnection;
import org.example.views.GRegisterView;

public class GRegisterController extends GController{

    private GRegisterView gRegisterView;

    private GLoginRegisterController gLoginRegisterController;
    private GLoginController gLoginController;

    private GMenuController gMenuController;
    public GRegisterController(GLoginRegisterController gLoginRegisterController, GLoginController gLoginController) {
        gRegisterView = new GRegisterView(this, jframe);
        this.gLoginRegisterController = gLoginRegisterController;
        this.gLoginController = gLoginController;
    }

    public void run() {
        gRegisterView.show();
    }


    public void getNewLoginRegisterView() {
        gLoginRegisterController.run();
    }

    public String checkDataRegister(String name, String username, String email, String password1, String password2) {
        IConnection connection = Database.getConnection();
        if(password1.equals(password2)){
            if(!name.equals("") && !username.equals("") && !email.equals("") && !password1.equals("")) {
                connection.addUser(name, username, email, password1);
                GController.saveData();
                return "Zarejestrowano pomyślnie, za 3 sekundy nastąpi przekierowanie do ekranu logowania!";
            }
            return "Uzupełnij wszystkie pola!";
        }
        return "Hasła są różne - rejestracja nie powiodła się!";
    }

    public void getNewLoginView() {
        gLoginController.run();
    }
}

