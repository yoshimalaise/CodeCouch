package com.example.application.views.mobile;

import com.example.application.bl.Game;
import com.example.application.bl.Server;
import com.example.application.model.Player;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.MobileContainer;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Location;

public class JoinView extends BaseView {
    private MobileContainer container;

    public JoinView(MobileContainer c) {
        super(Server.findGameById(c.gameId));
        this.container = c;
        TextField txtName = new TextField("Player name");
        Button btnJoin = new Button("Join game");
        btnJoin.addClickListener(event -> {
            Player p = Server.addPlayer(c.gameId, txtName.getValue(), c);
            container.player = p;
            c.switchToView(new SessionSetupView(p));
        });
        this.add(txtName, btnJoin);
        this.setHorizontalComponentAlignment(Alignment.CENTER);
        this.setAlignItems(FlexComponent.Alignment.CENTER);
    }
}
