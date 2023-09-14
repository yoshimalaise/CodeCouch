package com.example.application.views.desktop;

import com.example.application.model.GameTutorial;
import com.example.application.views.main.BaseView;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class TutorialView extends BaseView {

    public TutorialView(GameTutorial tut) {
        setAlignItems(Alignment.CENTER);
        setHorizontalComponentAlignment(Alignment.CENTER);

        Span lblTitle = new Span(tut.gameName);
        Image img = new Image();
        img.setSrc(tut.visual);
        img.setWidth("60%");
        img.getStyle().set("border-radius", "8px");
        Span lblDescription = new Span(tut.GameDescription);
        add(lblTitle, img, lblDescription);
    }
}
