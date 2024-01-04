package org.example.strategy;

import org.example.Database;
import org.example.IConnection;
import org.example.Word;
import org.example.strategy.DifficultyStrategy;

import java.util.List;

public class Difficulty2 implements DifficultyStrategy {

    IConnection connection = Database.getConnection();

    @Override
    public List<Word> downloadWords() {
        return connection.getRandomWords(2);
    }
}
