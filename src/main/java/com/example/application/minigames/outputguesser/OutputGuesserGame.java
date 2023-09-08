package com.example.application.minigames.outputguesser;

import com.example.application.bl.commands.BaseCommand;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.outputguesser.components.OutputGuesserMainView;
import com.example.application.model.GameTutorial;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.example.application.views.mobile.WaitView;

public class OutputGuesserGame implements BaseMiniGame {
    private OutputGuesserMainView view;

    public OutputGuesserGame() {

    }

    @Override
    public void handleCommand(BaseCommand command) {

    }

    @Override
    public GameTutorial getTutorial() {
        return new OutputGuesserTutorial();
    }

    public BaseView getMobileView(Player player) {
        return new WaitView(player);
    }

    @Override
    public BaseView getDesktopView() {
        if (this.view == null) {
            this.view = new OutputGuesserMainView();
        }
        return this.view;
    }
}
