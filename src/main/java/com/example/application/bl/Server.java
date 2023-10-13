package com.example.application.bl;

import com.example.application.bl.commands.BaseCommand;
import com.example.application.model.GameState;
import com.example.application.model.Player;
import com.example.application.views.desktop.DesktopView;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.DesktopContainer;
import com.example.application.views.main.MobileContainer;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Server {
    private static Random r = new Random();
    private static ArrayList<Game> games = new ArrayList<>();

    public static Game newGame(DesktopContainer c) {
        Game g = new Game(c, generateId());
        games.add(g);
        c.game = g;
        return g;
    }

    public static void handleCommand(BaseCommand command) {
        Game g = findGameById(command.player.gameId);
        if (g != null) {
            g.handleCommand(command);
        }
    }

    public static Player addPlayer(String gameId, String username, MobileContainer c) {
        try {
            return findGameById(gameId).addPlayer(username,c);
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public static void switchAllMobileClientsToView(String gameId, Function<Player, BaseView> vGenerator){
        try {
            Game g = findGameById(gameId);
            g.getPlayers().forEach(p -> {
                p.getClient().switchToView(vGenerator.apply(p));
            });
        } catch (NullPointerException ex) {
            // :)
        }
    }

    private static ArrayList<String> existingIds = new ArrayList<>();
    private static String generateId() {
        String id = "" + r.nextInt(10000000, 99999999);
        while (existingIds.contains(id)) {
            id = "" + r.nextInt(10000000, 99999999);
        }
        existingIds.add(id);
        return id;
    }

    public static Game findGameById(String id) {
        try {
            return games.stream().filter(g -> g.gameId.equals(id)).toList().get(0);
        } catch (IndexOutOfBoundsException e){
            return null;
        }
    }



}
