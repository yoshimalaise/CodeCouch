package com.example.application.minigames.outputguesser;

import com.example.application.bl.commands.BaseCommand;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.outputguesser.components.OutputGuesserMainView;
import com.example.application.model.GameTutorial;
import com.example.application.views.main.BaseView;
import com.example.application.views.mobile.WaitView;

public class OutputGuesserGame implements BaseMiniGame {
    private OutputGuesserMainView view;

    public OutputGuesserGame() {
        this.view = new OutputGuesserMainView();
    }

    @Override
    public void handleCommand(BaseCommand command) {

    }

    @Override
    public GameTutorial getTutorial() {
        return new OutputGuesserTutorial();
    }

    @Override
    public BaseView getMobileView() {
        return new WaitView();
    }

    @Override
    public BaseView getDesktopView() {
        return this.view;
    }
}
