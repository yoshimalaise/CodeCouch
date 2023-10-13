package com.example.application.views.desktop.components;

import com.example.application.bl.Game;
import com.example.application.model.Player;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class PlayersOverview extends HorizontalLayout {
    Game game;
    public PlayersOverview(Game game) {
        this.game = game;
        this.update();
    }

    public void update() {
        this.removeAll();
        for (Player player : game.getPlayers()) {
            this.add(new PlayerAvatarComponent(player));
        }
    }
}
