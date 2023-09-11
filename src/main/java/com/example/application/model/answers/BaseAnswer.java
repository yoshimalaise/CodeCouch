package com.example.application.model.answers;

import com.example.application.model.Player;

public class BaseAnswer {
    public Player player;

    public BaseAnswer(Player player) {
        this.player = player;
        player.hasAnswered = true;
    }
}
