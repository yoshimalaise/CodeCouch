package com.example.application.minigames.resultguesser;

import com.example.application.bl.commands.BaseCommand;
import com.example.application.bl.commands.StringAnswerCommand;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.outputguesser.OutputGuesserTutorial;
import com.example.application.minigames.outputguesser.components.OutputGuesserMainView;
import com.example.application.model.GameTutorial;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.example.application.views.mobile.WaitView;

public class ResultGuesserGame implements BaseMiniGame {

    private ResultGuesserGameView view;

    @Override
    public void handleCommand(BaseCommand command) {
        if (command instanceof StringAnswerCommand c) {
            view.handleAnswer(c.player, c.getAnswer());
        }
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
            this.view = new ResultGuesserGameView();
        }
        return this.view;
    }
}
