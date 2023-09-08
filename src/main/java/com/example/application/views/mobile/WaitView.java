package com.example.application.views.mobile;

import com.example.application.bl.Game;
import com.example.application.bl.commands.ContinueCommand;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

import java.awt.*;


public class WaitView extends BaseView {

    public WaitView(Player p) {
        Span lblPlayerName = new Span(p.getName() + " - " + p.getScore());
        Span lblPleaseWait = new Span("Waiting for all players to get ready.");
        Button btnContinue = new Button("Continue");
        btnContinue.addClickListener(b -> Game.handleCommand(new ContinueCommand()));
        this.add(lblPlayerName, lblPleaseWait, btnContinue);
    }
}
