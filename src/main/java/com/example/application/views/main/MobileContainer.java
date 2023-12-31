package com.example.application.views.main;

import com.example.application.model.Player;
import com.example.application.views.desktop.HomeView;
import com.example.application.views.mobile.JoinView;
import com.example.application.views.mobile.MobileView;
import com.example.application.views.mobile.WaitView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;

import java.util.ArrayList;
import java.util.function.Function;

@PageTitle("Main")
@Route(value = "/mobile") // with url parameter it will be ('/mobile/<gameId>')
@PreserveOnRefresh
public class MobileContainer extends VerticalLayout implements HasUrlParameter<String> {

    private BaseView currentView;
    public String gameId;
    public Player player;

    public MobileContainer() {
        this.switchToView(MobileView.JOIN_VIEW);
    }

    public void switchToView(MobileView v) {
        switch (v) {
            case JOIN_VIEW:
                this.currentView = new JoinView(this);
                break;
            case WAIT_VIEW:
                this.currentView = new WaitView(player);
                break;
        }

        if (this.getUI().isPresent()) {
            this.getUI().get().access(() -> {
                this.removeAll();
                this.add(this.currentView);
            });
        } else {
            this.removeAll();
            this.add(this.currentView);
        }
    }

    public void switchToView(BaseView v) {
        this.getUI().get().access(() -> {
            currentView = v;
            this.removeAll();
            this.add(v);
        });
    }

    public void update() {
        if (this.currentView != null && this.currentView.getUI().isPresent()) {
            this.currentView.getUI().get().access(() -> {
                this.currentView.update();
            });
        }
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String gameId) {
        this.gameId = gameId;
    }
}
