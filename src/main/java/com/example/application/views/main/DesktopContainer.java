package com.example.application.views.main;

import com.example.application.bl.Game;
import com.example.application.views.desktop.DesktopView;
import com.example.application.views.desktop.HomeView;
import com.example.application.views.desktop.LobbyView;
import com.example.application.views.mobile.JoinView;
import com.example.application.views.mobile.MobileView;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class DesktopContainer extends HorizontalLayout {

    private BaseView currentView;

    public DesktopContainer() {
        this.switchToView(DesktopView.HOME_VIEW);
    }

    public void switchToView(DesktopView v) {
        switch (v) {
            case HOME_VIEW:
                this.currentView = new HomeView(this);
                break;
            case LOBBY:
                this.currentView = new LobbyView();
                break;
        }

        this.getUI().get().access(() -> {
            this.removeAll();
            this.add(this.currentView);
        });
    }

    public void update() {
        if (this.currentView != null) {
            UI.getCurrent().access(() -> {
                this.currentView.update();
            });
        }
    }

}
