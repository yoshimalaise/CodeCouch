package com.example.application.minigames.outputguesser;

import com.example.application.bl.Game;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.model.BaseGameFactory;

public class OutputGuesserGameFactory extends BaseGameFactory {

    public OutputGuesserGameFactory(Game game) {
        super("Output guesser", game);
    }

    @Override
    public BaseMiniGame build() {
        return new OutputGuesserGame(game);
    }
}
