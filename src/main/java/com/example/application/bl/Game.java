package com.example.application.bl;

import com.example.application.model.Player;
import com.example.application.views.desktop.DesktopView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;
import com.vaadin.flow.component.UI;

import java.util.ArrayList;
import java.util.List;


public abstract class Game {
    private static List<Player> players = new ArrayList<>();
    private static DesktopContainer desktopContainer;

    public static void newGame(DesktopContainer c) {
        Game.players = new ArrayList<>();
        Game.desktopContainer = c;
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
}
