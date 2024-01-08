package org.example.controllers;

import org.example.DataController;
import org.example.Database;
import org.example.IConnection;

import javax.swing.*;

public abstract class GController {
    protected static final JFrame jframe;
    static DataController dataController = new DataController();


    static {
        dataController.LoadDataUser();
        dataController.LoadDataWord();
        jframe = new JFrame("Aplikacja do nauki słówek");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(800, 480);
        jframe.setLocationRelativeTo(null);
    }

    public static void addWord(String polishWord,String englishWord) {
        IConnection connection = Database.getConnection();
        connection.addWord(polishWord, englishWord);
    }

    public static void addUser(String name,String username,String email,String password) {
        IConnection connection = Database.getConnection();
        connection.addUser(name, username, email, password);
    }

    protected static void exitApp() {
        dataController.saveDataWord();
        dataController.saveDataUser();
        System.exit(0);
    }

    protected static void saveData() {
        dataController.saveDataWord();
        dataController.saveDataUser();
    }
}

