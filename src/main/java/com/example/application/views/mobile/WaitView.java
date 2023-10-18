package com.example.application.views.mobile;

import com.example.application.bl.Game;
import com.example.application.bl.Server;
import com.example.application.bl.commands.ContinueCommand;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;

import java.awt.*;


public class WaitView extends BaseView {

    public WaitView(Player p) {
        super(Server.findGameById(p.gameId));
        Span lblPlayerName = new Span(p.getName() + " - " + p.getScore());
        Span lblPleaseWait = new Span("Wait until all players are ready, then press continue to start the game.");
        Button btnContinue = new Button("Continue");
        btnContinue.addClickListener(b -> Server.handleCommand(new ContinueCommand(p)));
        this.add(lblPlayerName, lblPleaseWait, btnContinue);
    }
}
