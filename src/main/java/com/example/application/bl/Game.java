package com.example.application.bl;

import com.example.application.bl.commands.BaseCommand;
import com.example.application.bl.commands.ContinueCommand;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.outputguesser.OutputGuesserGameFactory;
import com.example.application.minigames.trueOrFalse.TrueOrFalseGameFactory;
import com.example.application.minigames.trueOrFalse.chapter.ChapterOne;
import com.example.application.model.GameState;
import com.example.application.model.BaseGameFactory;
import com.example.application.model.Player;
import com.example.application.views.desktop.DesktopView;
import com.example.application.views.desktop.TutorialView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;
import com.example.application.views.mobile.MobileView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public abstract class Game {

    private static BaseMiniGame currentMiniGame;

    private static GameState state;

    private static int currentGameCtr = 0;
    public final static ArrayList<BaseGameFactory> generators = MiniGameFactoryCollection.getAllFactories();

    private static List<BaseGameFactory> selectedGenerators;

    private static List<Player> players = new ArrayList<>();
    private static DesktopContainer desktopContainer;

    public static void newGame(DesktopContainer c) {
        Game.currentGameCtr = -1;
        Game.state = GameState.NEW;
        Game.players = new ArrayList<>();
        Game.desktopContainer = c;
        Game.desktopContainer.switchToView(DesktopView.LOBBY);
        Game.desktopContainer.update();
    }

    public static Player addPlayer(String username, MobileContainer client) {
        Player p = new Player(username, client);
        Game.players.add(p);
        Game.desktopContainer.update();
        return p;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void handleCommand(BaseCommand command) {
        if (command instanceof ContinueCommand && (Game.state == GameState.SHOWING_SCORES || Game.state == GameState.NEW)) {
            Collections.shuffle(Game.generators);
            selectedGenerators = generators.stream().filter(f -> f.included).toList();
            loadNextMiniGame();
        } else if (command instanceof ContinueCommand && Game.state == GameState.SHOWING_TUTORIAL) {
            Game.desktopContainer.switchToView(Game.currentMiniGame.getDesktopView());
        } else {
            if (Game.currentMiniGame != null) {
                Game.currentMiniGame.handleCommand(command);
            }
        }
    }

    public static void loadNextMiniGame(){
        clearPlayersRoundInfo();
        Game.currentGameCtr++;
        Game.state = GameState.SHOWING_TUTORIAL;
        Game.currentMiniGame = Game.selectedGenerators.get(Game.currentGameCtr % selectedGenerators.size()).build();
        Game.desktopContainer.switchToView(new TutorialView(Game.currentMiniGame.getTutorial()));
        Game.players.forEach(p -> p.getClient().switchToView(MobileView.WAIT_VIEW));
    }

    public static void clearPlayersRoundInfo() {
        for (Player player : players) {
            player.clearRoundInfo();
        }
    }

    public static void updateAllScreens() {
        Game.desktopContainer.update();
        players.forEach(p -> p.getClient().update());
    }


}
