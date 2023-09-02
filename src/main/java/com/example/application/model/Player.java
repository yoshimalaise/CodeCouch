package com.example.application.model;

import com.example.application.views.main.MobileContainer;

public class Player {
    private String name;
    private int score;
    private MobileContainer client;

    public Player(String name, MobileContainer client) {
        this.name = name;
        this.client = client;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public MobileContainer getClient() {
        return client;
    }

    public void setClient(MobileContainer client) {
        this.client = client;
    }
}
