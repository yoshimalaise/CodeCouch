package com.example.application.model.answers;

import com.example.application.model.Player;

public class StringAnswer extends BaseAnswer {
    public String answer;

    public StringAnswer(Player player, String answer) {
        super(player);
        this.answer = answer;
    }
}
