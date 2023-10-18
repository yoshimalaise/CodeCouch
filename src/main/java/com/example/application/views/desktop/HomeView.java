package com.example.application.views.desktop;

import com.example.application.bl.Game;
import com.example.application.bl.Server;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.DesktopContainer;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;

public class HomeView extends BaseView {
    private DesktopContainer container;
    private Button btnStart;

    public HomeView(DesktopContainer c) {
        super(null);
        this.container = c;

        Image imgLogo = new Image("icons/CodeCouchLogo.png", "The logo");
        imgLogo.setWidth("40%");

        btnStart = new Button("Start Game");
        btnStart.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnStart.addClickListener(e -> {
            Server.newGame(c);
        });
        btnStart.addClickShortcut(Key.ENTER);

        setMargin(true);
        this.setAlignItems(Alignment.CENTER);
        this.setHorizontalComponentAlignment(Alignment.CENTER);

        add(imgLogo, btnStart);
    }
}
