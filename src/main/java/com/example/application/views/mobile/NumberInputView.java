package com.example.application.views.mobile;

import com.example.application.bl.Game;
import com.example.application.bl.commands.StringAnswerCommand;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;

public class NumberInputView extends BaseView {
    public NumberInputView(Player p) {
        IntegerField numberField = new IntegerField("Your answer: ");
        this.setAlignItems(Alignment.CENTER);
        add(numberField);
        Button btn = new Button("Submit");
        btn.addClickListener(e -> {
            removeAll();
            add(new Span("Waiting for others to finish"));
            Game.handleCommand(new StringAnswerCommand(p, numberField.getValue() + ""));
        });
        add(btn);
    }
}
