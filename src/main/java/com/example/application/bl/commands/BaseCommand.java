package com.example.application.bl.commands;

import com.example.application.model.Player;

public abstract class BaseCommand {
    public Player player;

    public BaseCommand() {
    }

    public BaseCommand(Player player) {
        this.player = player;
    }
}
