package com.example.application.views.mobile;

import com.example.application.bl.Game;
import com.example.application.bl.commands.ContinueCommand;
import com.example.application.views.main.BaseView;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;



public class WaitView extends BaseView {

    public WaitView() {
        Span txtPleaseWait = new Span("Waiting for all players to get ready.");
        Button btnContinue = new Button("Continue");
        btnContinue.addClickListener(b -> Game.handleCommand(new ContinueCommand()));
        this.add(txtPleaseWait, btnContinue);
    }
}
