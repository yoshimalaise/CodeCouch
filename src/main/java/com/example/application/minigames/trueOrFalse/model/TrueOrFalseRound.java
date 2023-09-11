package com.example.application.minigames.trueOrFalse.model;

import java.util.ArrayList;
import java.util.List;

public class TrueOrFalseRound {
    public String description;
    public TrueOrFalseType roundType;
    public List<String> options;
    public String correctAnswer;

    public TrueOrFalseRound(String description, TrueOrFalseType roundType, List<String> options, String correctAnswer) {
        this.description = description;
        this.roundType = roundType;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }
}
