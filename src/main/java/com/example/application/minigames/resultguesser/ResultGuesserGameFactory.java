package com.example.application.minigames.resultguesser;

import com.example.application.bl.Game;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.model.BaseGameFactory;

public class ResultGuesserGameFactory extends BaseGameFactory {
    public ResultGuesserGameFactory(Game game) {
        super("Result Guesser", game);
    }

    @Override
    public BaseMiniGame build() {
        return new ResultGuesserGame(game);
    }
}
