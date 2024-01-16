package org.example;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> Users = new ArrayList<>();
    private List<Word> Words = new ArrayList<>();
    private List<Word> WordsFamiliarized = new ArrayList<>();
    private static final Database database = new Database();

    private Database(){}
    private static Database getInstance() {
        return database;
    }
    public static IConnection getConnection() {
        return Connection.getInstance();
    }
    private static class Connection implements IConnection {
        private final Database database = Database.getInstance();
        private static final Connection Connection1 = new Connection();
        private static final Connection Connection2 = new Connection();
        private static final Connection Connection3 = new Connection();
        private static final Connection[] Connections = {Connection1, Connection2, Connection3};
        private static int i = 0;
        private Connection(){}
        private static IConnection getInstance() {
            IConnection connection = Connections[i];
            i = (i+1)%3;
            return connection;
        }
        public List<User> getUsers() {
            return database.Users;
        }

        public void addUser(String name, String username, String email, String password) {
            database.Users.add(new User(name, username, email, password));
        }

        public List<Word> getWords() {
            return database.Words;
        }

        public List<Word> getWordsFamiliarized() {
            return database.WordsFamiliarized;
        }

        public List<Word> getRandomWords(int number) {
            List<Word> list = new ArrayList<>();
            for (Word word : database.Words) {
                list.add(word);
            }
            List<Word> words = new ArrayList<>();
            for (int i = 0; i < number; i++) {
                int randomIndex = (int) (Math.random() * list.size());
                words.add(list.get(randomIndex));
                list.remove(randomIndex);
            }
            return words;
        }

        public Word getRandomWord() {
            List<Word> list = database.WordsFamiliarized;
            int randomIndex = (int) (Math.random() * list.size());
            return list.get(randomIndex);
        }

        @Override
        public void removeWordFamiliarized(Word word) {
            database.WordsFamiliarized.remove(word);
        }

        public void removeWord(String polishWord) {
            List<Word> list = database.WordsFamiliarized;
            for (Word word : list) {
                if (word.getPolishWord().equals(polishWord)) {
                    list.remove(word);
                    return;
                }
            }
        }

        public void addWordFamiliarized(String polishWord, String englishWord) {
            database.WordsFamiliarized.add(new Word(polishWord, englishWord));
        }

        public void addWord(String polishWord, String englishWord) {
            database.Words.add(new Word(polishWord, englishWord));
        }
        @Override
        public void refreshWordFamiliarized() {
            database.WordsFamiliarized.clear();
            for (Word word: database.Words){
                database.WordsFamiliarized.add(word);
            }
        }
    }
}

