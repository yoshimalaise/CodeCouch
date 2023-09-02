package com.example.application.bl;

import com.example.application.bl.commands.BaseCommand;
import com.example.application.bl.commands.ContinueCommand;
import com.example.application.bl.commands.LoadNextLevelCommand;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.outputguesser.OutputGuesserGame;
import com.example.application.model.Player;
import com.example.application.views.desktop.DesktopView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;
import com.vaadin.flow.component.UI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;


public abstract class Game {

    private static BaseMiniGame currentMiniGame;

    private static int currentGameCtr = 0;
    private final static ArrayList<Supplier<BaseMiniGame>> generators = new ArrayList<Supplier<BaseMiniGame>>() {{
        add(OutputGuesserGame::new);
    }};


    private static List<Player> players = new ArrayList<>();
    private static DesktopContainer desktopContainer;

    public static void newGame(DesktopContainer c) {
        Game.currentGameCtr = -1;
        Game.players = new ArrayList<>();
        Game.desktopContainer = c;
        Collections.shuffle(Game.generators);
        Game.desktopContainer.switchToView(DesktopView.LOBBY);
        Game.desktopContainer.update();
    }

    public static void addPlayer(String username, MobileContainer client) {
        Game.players.add(new Player(username, client));
        Game.desktopContainer.update();
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void handleCommand(BaseCommand command) {
        if (command instanceof LoadNextLevelCommand) {
            Game.currentGameCtr++;
            Game.currentMiniGame = Game.generators.get(Game.currentGameCtr).get();
        } else {
            if (Game.currentMiniGame != null) {
                Game.currentMiniGame.handleCommand(command);
            }
        }
    }
}
