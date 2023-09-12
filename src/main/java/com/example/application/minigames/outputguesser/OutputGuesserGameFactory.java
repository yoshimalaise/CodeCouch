package com.example.application.minigames.outputguesser;

import com.example.application.minigames.BaseMiniGame;
import com.example.application.model.BaseGameFactory;

public class OutputGuesserGameFactory extends BaseGameFactory {

    public OutputGuesserGameFactory() {
        super("Output guesser");
    }

    @Override
    public BaseMiniGame build() {
        return new OutputGuesserGame();
    }
}
