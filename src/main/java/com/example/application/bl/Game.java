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
import com.example.application.views.main.BaseView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;
import com.example.application.views.mobile.MobileView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Game {
    public String gameId;

    private BaseMiniGame currentMiniGame;

    private GameState state;

    private int currentGameCtr = 0;
    public final ArrayList<BaseGameFactory> generators;

    private List<BaseGameFactory> selectedGenerators;

    private List<Player> players;
    private DesktopContainer desktopContainer;

    public Game(DesktopContainer c, String gameId) {
        this.gameId = gameId;
        this.currentGameCtr = -1;
        this.state = GameState.NEW;
        this.players = new ArrayList<>();
        this.generators = MiniGameFactoryCollection.getAllFactories(this);
        this.desktopContainer = c;
        this.desktopContainer.game = this;
        this.desktopContainer.switchToView(DesktopView.LOBBY);
        this.desktopContainer.update();
        c.game = this;
    }

    public Player addPlayer(String username, MobileContainer client) {
        Player p = new Player(username, client, this.gameId);
        this.players.add(p);
        this.desktopContainer.update();
        return p;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void handleCommand(BaseCommand command) {
        if (command instanceof ContinueCommand && (this.state == GameState.SHOWING_SCORES || this.state == GameState.NEW)) {
            Collections.shuffle(this.generators);
            selectedGenerators = generators.stream().filter(f -> f.included).toList();
            loadNextMiniGame();
        } else if (command instanceof ContinueCommand && this.state == GameState.SHOWING_TUTORIAL) {
            this.desktopContainer.switchToView(this.currentMiniGame.getDesktopView());
        } else {
            if (this.currentMiniGame != null) {
                this.currentMiniGame.handleCommand(command);
            }
        }
    }

    public void loadNextMiniGame(){
        clearPlayersRoundInfo();
        this.currentGameCtr++;
        this.state = GameState.SHOWING_TUTORIAL;
        this.currentMiniGame = this.selectedGenerators.get(this.currentGameCtr % selectedGenerators.size()).build();
        this.desktopContainer.switchToView(new TutorialView(this, this.currentMiniGame.getTutorial()));
        this.players.forEach(p -> p.getClient().switchToView(MobileView.WAIT_VIEW));
    }

    public void clearPlayersRoundInfo() {
        for (Player player : players) {
            player.clearRoundInfo();
        }
    }

    public void updateAllScreens() {
        this.desktopContainer.update();
        players.forEach(p -> p.getClient().update());
    }

    public boolean allPlayersAnswered() {
        for (Player player : this.getPlayers()) {
            if (!player.hasAnswered) {
                return false;
            }
        }
        return true;
    }

    public DesktopContainer getContainer() {
        return desktopContainer;
    }

    public void switchAllMobileClientsToView(Function<Player, BaseView> vGenerator) {
        getPlayers().forEach(p -> {
            p.getClient().switchToView(vGenerator.apply(p));
        });
    }

}
