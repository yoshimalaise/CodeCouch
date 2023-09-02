package com.example.application.minigames;

import com.example.application.bl.commands.BaseCommand;
import com.example.application.model.GameTutorial;
import com.example.application.views.main.BaseView;

public interface BaseMiniGame {
    void handleCommand(BaseCommand command);

    GameTutorial getTutorial();

    BaseView getMobileView();

    BaseView getDesktopView();
}
