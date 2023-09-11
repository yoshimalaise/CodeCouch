package com.example.application.views.main;

import com.example.application.model.Player;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.function.Function;
import java.util.function.Supplier;

public class BaseView extends VerticalLayout {

    public BaseView() {
        this.setAlignItems(Alignment.CENTER);
        this.setHorizontalComponentAlignment(Alignment.CENTER);
    }


    public void update() {
        // can be overriden by views if they need to update themselves based on state changes in the game
    }

    public void updateUIInLock(Runnable cb) {
        if (this.getUI().isPresent()) {
            this.getUI().get().access(cb::run);
        } else {
            cb.run();
        }
    }
}
