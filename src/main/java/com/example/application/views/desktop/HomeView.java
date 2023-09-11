package com.example.application.views.desktop;

import com.example.application.bl.Game;
import com.example.application.views.main.BaseView;
import com.example.application.views.main.DesktopContainer;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;

public class HomeView extends BaseView {
    private DesktopContainer container;
    private Button btnStart;

    public HomeView(DesktopContainer c) {
        this.container = c;

        btnStart = new Button("Start Game");
        btnStart.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btnStart.addClickListener(e -> {
            Game.newGame(c);
        });
        btnStart.addClickShortcut(Key.ENTER);

        setMargin(true);
        this.setAlignItems(Alignment.CENTER);
        this.setHorizontalComponentAlignment(Alignment.CENTER);

        add(btnStart);
    }
}
