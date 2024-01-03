package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataController dataController = new DataController();
        dataController.LoadDataUser();
        dataController.LoadDataWord();

        IConnection connection = Database.getConnection();
        List<User> users = connection.getUsers();
        for (User user : users) {
            System.out.println("ID: " + user.id + ", Imie: " + user.name+ ", Nazwisko: " + user.username + ", Email: " + user.email + ", Hasło: " + user.password);
        }

        List<Word> words = connection.getWords();
        for (Word word : words) {
            System.out.println("ID: " + word.id + ", Słowo polskie: " + word.polishWord+ ", Słowo angielskie: " + word.englishWord);
        }
//        connection.addUser("test","test","test", "test");
//        connection.addWord("test", "test");
        dataController.saveDataUser();
        dataController.saveDataWord();
    }
}