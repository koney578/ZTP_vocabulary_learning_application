package org.example.controllers;

import org.example.Database;
import org.example.IConnection;
import org.example.User;
import org.example.views.GLoginView;

import java.util.List;

public class GLoginController extends GController{

    private GLoginView gLoginView;

    private GLoginRegisterController gLoginRegisterController;

    private GMenuController gMenuController;
    public GLoginController(GLoginRegisterController gLoginRegisterController) {
        gLoginView = new GLoginView(this, jframe);
        this.gMenuController = new GMenuController(this);
        this.gLoginRegisterController = gLoginRegisterController;
    }

    public void run() {
        gLoginView.show();
    }

    public String checkDataLogin(String username, String password) {
        IConnection connection = Database.getConnection();
        List<User> users = connection.getUsers();
        for (User user : users) {
            if (user.getUsername().equals(username) & user.getPassword().equals(password)) {
                gMenuController.run();
                return "Zalogowano pomyślnie";
            }
        }
        return "Nieprawidłowe dane logowania!";
    }

    public void getNewLoginRegisterView() {
        gLoginRegisterController.run();
    }

//    public void getNewMenuView() {
//        gMenuController.run();
//    }
}
