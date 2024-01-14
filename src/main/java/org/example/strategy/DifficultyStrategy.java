package org.example.strategy;

import org.example.Word;

import java.util.List;

public interface DifficultyStrategy {
    List<Word> downloadWords();
}