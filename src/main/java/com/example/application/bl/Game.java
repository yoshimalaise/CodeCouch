package com.example.application.bl;

import com.example.application.bl.commands.BaseCommand;
import com.example.application.bl.commands.ContinueCommand;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.outputguesser.OutputGuesserGame;
import com.example.application.model.GameState;
import com.example.application.model.Player;
import com.example.application.views.desktop.DesktopView;
import com.example.application.views.desktop.TutorialView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;
import com.example.application.views.mobile.MobileView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;


public abstract class Game {

    private static BaseMiniGame currentMiniGame;

    private static GameState state;

    private static int currentGameCtr = 0;
    private final static ArrayList<Supplier<BaseMiniGame>> generators = new ArrayList<Supplier<BaseMiniGame>>() {{
        add(OutputGuesserGame::new);
    }};


    private static List<Player> players = new ArrayList<>();
    private static DesktopContainer desktopContainer;

    public static void newGame(DesktopContainer c) {
        Game.currentGameCtr = -1;
        Game.state = GameState.NEW;
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
        if (command instanceof ContinueCommand && (Game.state == GameState.SHOWING_SCORES || Game.state == GameState.NEW)) {
            Game.currentGameCtr++;
            Game.currentMiniGame = Game.generators.get(Game.currentGameCtr).get();
            Game.state = GameState.SHOWING_TUTORIAL;
            Game.desktopContainer.switchToView(new TutorialView(Game.currentMiniGame.getTutorial()));
            Game.players.forEach(p -> p.getClient().switchToView(MobileView.WAIT_VIEW));
        } else if (command instanceof ContinueCommand && Game.state == GameState.SHOWING_TUTORIAL) {
            Game.desktopContainer.switchToView(Game.currentMiniGame.getDesktopView());
            Game.players.forEach(p -> p.getClient().switchToView(Game.currentMiniGame.getMobileView()));
        } else {
            if (Game.currentMiniGame != null) {
                Game.currentMiniGame.handleCommand(command);
            }
        }
    }
}
