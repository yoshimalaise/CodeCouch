package com.example.application.minigames.outputguesser;

import com.example.application.bl.Game;
import com.example.application.bl.commands.BaseCommand;
import com.example.application.bl.commands.StringAnswerCommand;
import com.example.application.minigames.BaseMiniGame;
import com.example.application.minigames.outputguesser.components.OutputGuesserMainView;
import com.example.application.model.GameTutorial;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.example.application.views.mobile.WaitView;

public class OutputGuesserGame implements BaseMiniGame {
    private OutputGuesserMainView view;
    private Game game;

    public OutputGuesserGame(Game g) {
        this.game = g;
    }

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

    @Override
    public BaseView getDesktopView() {
        if (this.view == null) {
            this.view = new OutputGuesserMainView(game);
        }
        return this.view;
    }

    @Override
    public Game getGame() {
        return game;
    }
}
