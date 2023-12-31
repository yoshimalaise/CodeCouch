package com.example.application.views.mobile;

import com.example.application.bl.Game;
import com.example.application.bl.Server;
import com.example.application.bl.commands.ContinueCommand;
import com.example.application.model.BaseGameFactory;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.virtuallist.VirtualList;
import com.vaadin.flow.data.renderer.BasicRenderer;
import com.vaadin.flow.data.renderer.ComponentRenderer;

import java.awt.*;

public class SessionSetupView extends BaseView {
    Player player;
    Button btnContinue;

    Span lblPlayerCount;

    VirtualList<BaseGameFactory> minigamesList;

    private Game g;

    public SessionSetupView(Player p) {
        super(Server.findGameById(p.gameId));
        this.player = p;

        Span lblName = new Span(p.getName());
        this.g = Server.findGameById(p.gameId);
        lblPlayerCount = new Span(g.getPlayers().size() + (g.getPlayers().size() > 1 ? " players" : " player"));

        btnContinue = new Button("Start Game");
        btnContinue.addClickListener(b -> g.handleCommand(new ContinueCommand(p)));

        // prepare the list of all the generators
        minigamesList = new VirtualList<>();
        minigamesList.setRenderer(new ComponentRenderer<Component, BaseGameFactory>(factory -> {
            Checkbox c = new Checkbox();
            c.setLabel(factory.name);
            c.setValue(factory.included);
            c.addValueChangeListener(e -> {
                factory.included = e.getValue();
                g.updateAllScreens();
            });
            return c;
        }));
        minigamesList.setItems(g.generators);

        add(lblName, lblPlayerCount, minigamesList, btnContinue);
    }

    @Override
    public void update() {
        this.updateUIInLock(() -> {
            lblPlayerCount.setText(g.getPlayers().size() + (g.getPlayers().size() > 1 ? " players" : " player"));
            minigamesList.setItems(g.generators);
        });
    }
}
