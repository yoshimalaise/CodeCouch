package com.example.application.minigames.resultguesser;

import com.example.application.bl.Game;
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
    private Game game;

    public ResultGuesserGame(Game game) {
       this.game = game;
    }

    @Override
    public void handleCommand(BaseCommand command) {
        if (command instanceof StringAnswerCommand c) {
            view.handleAnswer(c.player, c.getAnswer());
        }
    }

    @Override
    public GameTutorial getTutorial() {
        return new ResultGuesserTutorial();
    }

    @Override
    public BaseView getDesktopView() {
        if (this.view == null) {
            this.view = new ResultGuesserGameView(game);
        }
        return this.view;
    }

    @Override
    public Game getGame() {
        return null;
    }
}
