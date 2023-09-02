package com.example.application.views.main;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class BaseView extends VerticalLayout {
    public BaseView() {
        this.setAlignItems(Alignment.CENTER);
        this.setHorizontalComponentAlignment(Alignment.CENTER);
    }


    public void update() {
        // can be overriden by views if they need to update themselves based on state changes in the game
    }
}
