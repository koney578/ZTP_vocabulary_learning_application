package org.example;

import java.util.List;

public interface IConnection {
    List<User> getUsers();
    void addUser(String name, String username, String email, String password);
    List<Word> getWords();
    void addWord(String polishWord, String englishWord);

    List<Word> getRandomWords(int i);
}
