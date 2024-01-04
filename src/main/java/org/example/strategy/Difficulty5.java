package org.example.strategy;

import org.example.Database;
import org.example.IConnection;
import org.example.Word;

import java.util.Collections;
import java.util.List;

public class Difficulty5 implements DifficultyStrategy {

    IConnection connection = Database.getConnection();

    @Override
    public List<Word> downloadWords() {
        return Collections.emptyList();
    }
}
