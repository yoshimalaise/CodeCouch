package com.example.application.views.mobile;

import com.example.application.bl.Game;
import com.example.application.bl.commands.StringAnswerCommand;
import com.example.application.model.Player;
import com.example.application.views.desktop.components.AnswerBox;
import com.example.application.views.main.BaseView;
import com.example.application.views.mobile.components.ClickableAnswerBox;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;

import java.util.ArrayList;
import java.util.List;

public class PickOneOptionView extends BaseView {


    public PickOneOptionView(List<String> options, Player p) {
        add(new H1("Pick one:"));
        for (String option : options) {
            add(new ClickableAnswerBox(option, e -> {
                removeAll();
                add(new Span("Waiting for others to finish"));
                Game.handleCommand(new StringAnswerCommand(p, option));
            }));
        }
    }
}
