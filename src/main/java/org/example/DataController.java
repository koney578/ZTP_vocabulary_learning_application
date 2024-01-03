package org.example;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DataController {
    String nameFileUser = "src/main/java/org/example/data/users.txt";
    String nameFileWord = "src/main/java/org/example/data/words.txt";
    public void LoadDataUser() {
        try {
            IConnection connection = Database.getConnection();
            File file = new File(nameFileUser);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                if (values.length == 4) {
                    String name = values[0];
                    String username= values[1];
                    String email= values[2];
                    String password= values[3];
                    connection.addUser(name, username, email, password);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie można znaleźć pliku: " + nameFileUser);
        }
    }

    public void LoadDataWord() {
        try {
            IConnection connection = Database.getConnection();
            File file = new File(nameFileWord);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(";");
                if (values.length == 2) {
                    String polishWord = values[0];
                    String englishWord= values[1];
                    connection.addWord(polishWord, englishWord);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Nie można znaleźć pliku: " + nameFileWord);
        }
    }

    public void saveDataUser() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFileUser))) {
            IConnection connection = Database.getConnection();
            List<User> users = connection.getUsers();
            for (User user : users) {
                String userData = user.getName() + ";" + user.getUsername() + ";" +
                        user.getEmail() + ";" + user.getPassword();
                writer.write(userData);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDataWord() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFileWord))) {
            IConnection connection = Database.getConnection();
            List<Word> words = connection.getWords();
            for (Word word : words) {
                String wordData = word.getPolishWord() + ";" + word.getEnglishWord();
                writer.write(wordData);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
