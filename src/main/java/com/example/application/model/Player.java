package com.example.application.model;

import com.example.application.views.main.MobileContainer;

public class Player {
    private String name;
    private int score;
    private MobileContainer client;

    public String gameId;

    public boolean hasAnswered;
    public String roundMessage;

    public Player(String name, MobileContainer client, String gameId) {
        this.name = name;
        this.client = client;
        this.score = 0;
        this.hasAnswered = false;
        this.gameId = gameId;
    }

    public MobileContainer getClient() {
        return client;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void clearRoundInfo() {
        this.hasAnswered = false;
        this.roundMessage = "";
    }

    public void increaseScore(int score) {
        this.score += score;
        this.roundMessage = "+" + score;
    }
}
