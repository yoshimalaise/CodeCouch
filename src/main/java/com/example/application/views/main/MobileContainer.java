package com.example.application.views.main;

import com.example.application.views.desktop.HomeView;
import com.example.application.views.mobile.JoinView;
import com.example.application.views.mobile.MobileView;
import com.example.application.views.mobile.WaitView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "/mobile")
public class MobileContainer extends VerticalLayout {

    private BaseView currentView;

    public MobileContainer() {
        this.switchToView(MobileView.JOIN_VIEW);
    }

    public void switchToView(MobileView v) {
        switch (v) {
            case JOIN_VIEW:
                this.currentView = new JoinView(this);
                break;
            case WAIT_VIEW:
                this.currentView = new WaitView();
                break;
        }

        this.getUI().get().access(() -> {
            this.removeAll();
            this.add(this.currentView);
        });
    }

    public void update() {
        if (this.currentView != null) {
            this.getUI().get().getCurrent().access(() -> {
                this.currentView.update();
            });
        }
    }
}
