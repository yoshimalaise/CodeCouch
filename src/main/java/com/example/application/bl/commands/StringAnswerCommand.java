package com.example.application.bl.commands;

import com.example.application.model.Player;

public class StringAnswerCommand extends BaseCommand{
    private String answer;

    public StringAnswerCommand(Player player, String answer) {
        super(player);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
