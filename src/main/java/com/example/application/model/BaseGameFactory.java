package com.example.application.model;

import com.example.application.minigames.BaseMiniGame;

public abstract class BaseGameFactory {
    public boolean included = true;
    public String name;

    public BaseGameFactory(String name) {
        this.name = name;
    }

    public abstract BaseMiniGame build();
}
