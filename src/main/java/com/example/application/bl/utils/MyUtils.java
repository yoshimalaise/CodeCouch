package com.example.application.bl.utils;

import com.example.application.bl.Game;
import com.example.application.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class MyUtils {

    public static <T> T getRandomElFromList(List<T> els){
        Random random = new Random();
        return els.get(random.nextInt(els.size()));
    }

    public static boolean allPlayersAnswered() {
        for (Player player : Game.getPlayers()) {
            if (!player.hasAnswered) {
                return false;
            }
        }
        return true;
    }

}
