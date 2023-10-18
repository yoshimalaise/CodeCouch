package com.example.application.model;

import com.example.application.bl.Game;
import com.example.application.minigames.BaseMiniGame;

public abstract class BaseGameFactory {
    public boolean included = true;
    public Game game;
    public String name;

    public BaseGameFactory(String name, Game game) {
        this.name = name;
        this.game = game;
    }

    public abstract BaseMiniGame build();
}
