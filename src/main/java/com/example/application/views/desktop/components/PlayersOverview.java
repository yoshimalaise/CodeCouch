package com.example.application.views.desktop.components;

import com.example.application.bl.Game;
import com.example.application.model.Player;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class PlayersOverview extends HorizontalLayout {
    public PlayersOverview() {
        this.update();
    }

    public void update() {
        this.removeAll();
        for (Player player : Game.getPlayers()) {
            this.add(new PlayerAvatarComponent(player));
        }
    }
}
