package com.example.application.views.desktop.components;

import com.vaadin.flow.component.html.Span;

public class AnswerBox extends Span {
    public AnswerBox(String text) {
        super(text);
        addClassName("answer-box");
    }

    public void markCorrect() {
        this.addClassName("correct-answer");
    }
}
