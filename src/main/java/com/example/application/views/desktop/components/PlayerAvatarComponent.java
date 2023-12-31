package com.example.application.views.desktop.components;

import com.example.application.model.Player;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PlayerAvatarComponent extends VerticalLayout {


    public PlayerAvatarComponent(Player p) {
        setAlignItems(Alignment.CENTER);
        setHorizontalComponentAlignment(Alignment.CENTER);
        add(new Icon(p.hasAnswered ? VaadinIcon.CHECK_CIRCLE : VaadinIcon.CIRCLE));
        add(new Span(p.getName()));
        add(new Span(p.getScore()+ ""));
        if (p.roundMessage != null && p.roundMessage.length() > 0){
            Span roundMsg = new Span(p.roundMessage);
            roundMsg.getStyle().set("color", "green");
            add(roundMsg);
        }
        setPadding(true);
        setWidthFull();
    }
}
