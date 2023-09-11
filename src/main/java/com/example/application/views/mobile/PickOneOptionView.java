package com.example.application.views.mobile;

import com.example.application.bl.Game;
import com.example.application.bl.commands.StringAnswerCommand;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;

import java.util.ArrayList;
import java.util.List;

public class PickOneOptionView extends BaseView {


    public PickOneOptionView(List<String> options, Player p) {
        add(new H1("Pick one:"));
        for (String option : options) {
            Button btnOption = new Button();
            btnOption.setText(option);
            btnOption.setWidth("100%");
            btnOption.addClickListener(c -> {
                Game.handleCommand(new StringAnswerCommand(p, option));
            });
            add(btnOption);
        }
    }
}