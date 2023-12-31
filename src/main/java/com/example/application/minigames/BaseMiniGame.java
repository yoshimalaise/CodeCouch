package com.example.application.minigames;

import com.example.application.bl.Game;
import com.example.application.bl.commands.BaseCommand;
import com.example.application.model.GameTutorial;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;

public interface BaseMiniGame {

    void handleCommand(BaseCommand command);

    GameTutorial getTutorial();

    BaseView getDesktopView();

    Game getGame();
}
