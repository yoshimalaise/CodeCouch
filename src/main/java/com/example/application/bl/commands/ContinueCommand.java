package com.example.application.bl.commands;

import com.example.application.model.Player;

public class ContinueCommand  extends BaseCommand {
    public ContinueCommand() {
    }

    public ContinueCommand(Player player) {
        super(player);
    }
}
