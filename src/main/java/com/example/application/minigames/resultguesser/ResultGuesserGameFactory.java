package com.example.application.minigames.resultguesser;

import com.example.application.minigames.BaseMiniGame;
import com.example.application.model.BaseGameFactory;

public class ResultGuesserGameFactory extends BaseGameFactory {
    public ResultGuesserGameFactory() {
        super("Result Guesser");
    }

    @Override
    public BaseMiniGame build() {
        return new ResultGuesserGame();
    }
}
