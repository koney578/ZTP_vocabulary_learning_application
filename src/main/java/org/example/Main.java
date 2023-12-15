package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataController dataController = new DataController();
        dataController.LoadDataUser();

        IConnection connection = Database.getConnection();
        List<User> users = connection.getUsers();
        for (User user : users) {
            System.out.println("ID: " + user.id + ", Imie: " + user.name+ ", Nazwa: " + user.username + ", Email: " + user.email);
        }

    }
}