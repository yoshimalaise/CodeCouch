package com.example.application.views.mobile.components;

import com.example.application.views.desktop.components.AnswerBox;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.Span;

public class ClickableAnswerBox extends AnswerBox {
    public ClickableAnswerBox(String text, ComponentEventListener<ClickEvent<Span>> clickHandler) {
        super(text);
        addClassName("clickable-answer-box");
        setWidth("100%");
        addClickListener(clickHandler);
    }
}
