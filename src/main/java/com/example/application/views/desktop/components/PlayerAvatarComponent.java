package com.example.application.views.desktop.components;

import com.example.application.model.Player;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PlayerAvatarComponent extends VerticalLayout {
    private Player player;

    public PlayerAvatarComponent(Player p) {
        this.player = p;
        setAlignItems(Alignment.CENTER);
        setHorizontalComponentAlignment(Alignment.CENTER);

        Icon icon = new Icon(VaadinIcon.ACADEMY_CAP);
        Span lblName = new Span(p.getName());
        Span lblScore = new Span(p.getScore()+ "");
        setPadding(true);
        add(icon, lblName, lblScore);
        setWidthFull();
    }
}
